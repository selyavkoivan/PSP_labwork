import java.net.*;
import java.io.*;
import java.util.Arrays;
public class UDPServer {
    public final static int DEFAULT_PORT = 8001;

    public void runServer() throws IOException {
        DatagramSocket s = null;
        try {
            boolean stopFlag = false;

            byte[] buf = new byte[512];
            s = new DatagramSocket(DEFAULT_PORT);
            System.out.println("UDPServer: Started on " + s.getLocalAddress() + ":"
                    + s.getLocalPort());
            while(!stopFlag) {

                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
                s.receive(recvPacket);
                String cmd = new String(recvPacket.getData()).trim();
                System.out.println("UDPServer: Command: " + cmd);

                String answer = validation(cmd);
                buf = answer.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, recvPacket.getAddress(), recvPacket.getPort());
                s.send(sendPacket);
            }
            System.out.println("UDPServer: Stopped");
        }
        finally {
            if (s != null) {
                s.close();
            }
        }
    }
    public static void main(String[] args) {
        try {
            UDPServer udpSvr = new UDPServer();
            udpSvr.runServer();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    static String validation(String message)
    {
        String[] messages = message.split(" ");
        int x, y, z;
        if(messages.length != 3) return "Введено неверное количество элементов";
        try {
            x = Integer.parseInt(messages[0]);
            y = Integer.parseInt(messages[1]);
            z = Integer.parseInt(messages[2]);
        } catch (NumberFormatException e) {
            return "Не все введенные символы являются числами";



        }

        String answer =  Double.toString(function(x, y, z));
        fwrite(answer, x, y, z);

        return answer;
    }
    static double function(int x, int y, int z)
    {
        return ((Math.pow(Math.abs(Math.cos(x)-Math.pow(Math.E, y)), (1 + 2 * Math.pow(Math.log(y), 2)))*(1 + z + Math.pow(z, 2)/2 + Math.pow(z, 3)/3)));
    }
    static void fwrite(String answer, int x, int y, int z)
    {
        File file = new File("results.txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(answer + " " + x + " " + y + " " + z);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
