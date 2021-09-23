import java.net.*;
import java.io.*;

public class UDPClient {
    public void runClient() throws IOException {
        DatagramSocket s = null;
        try {
            byte[] buf = new byte[512];
            s = new DatagramSocket();
            System.out.println("UDPClient: Started");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String message;
            System.out.println("Введите x ");
            message = reader.readLine();
            System.out.println("Введите y ");
            message += " " + reader.readLine();
            System.out.println("Введите z ");
            message += " " + reader.readLine();



            byte[] verCmd = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(verCmd, verCmd.length, InetAddress.getByName("127.0.0.1"), 8001);
            s.send(sendPacket);


            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
            s.receive(recvPacket);
            String version = new String(recvPacket.getData()).trim();
            System.out.println("UDPClient: Server Version: " + version);

        }
        finally {
            if (s != null) {
                s.close();
            }  }  }
    public static void main(String[] args) {
        try {
            UDPClient client = new UDPClient();
            client.runClient();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
