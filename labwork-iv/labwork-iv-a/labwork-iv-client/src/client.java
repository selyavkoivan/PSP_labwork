import java.io.*;
import java.net.*;
public class client {
    public static void main(String[] arg) {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1",2525);
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());


            String clientMessage = stdin.readLine();
            while(!clientMessage.equals("quite"))
            {
                coos.writeObject(clientMessage);

                System.out.println(cois.readObject());

                clientMessage = stdin.readLine();
            }



            coos.close();
            cois.close();
            clientSocket.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
