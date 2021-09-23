import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] arg) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;
        ObjectInputStream sois = null;
        ObjectOutputStream soos = null;
        try {
            System.out.println("server starting....");
            serverSocket = new ServerSocket(2525);
            clientAccepted = serverSocket.accept();
            System.out.println("connection established....");
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());
            sois = new ObjectInputStream(clientAccepted.getInputStream());


            String clientMessageRecieved = (String) sois.readObject();
            while (!clientMessageRecieved.equals("quite")) {
                System.out.println("message recieved: '" + clientMessageRecieved + "'");

                clientMessageRecieved = Matrix(clientMessageRecieved);


                soos.writeObject(clientMessageRecieved);

                clientMessageRecieved = (String) sois.readObject();
            }


        }
        catch (Exception e) { }
        finally {
            try {
                sois.close();
                soos.close();
                clientAccepted.close();
                serverSocket.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String Matrix(String Message)
    {
        String[] matrix = Message.split(" ");

        if(matrix.length != 9) return "Введено неверное количество символов\nНеобходимо : 9\nВведено : " +  matrix.length;


        float[][] mas = new float[3][3];
        try {
            int counter = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                mas[j][i] = Float.parseFloat(matrix[counter]);
                counter++;

            }
        }
        } catch (NumberFormatException e) {
            return "Не все введенные символы являются числами";
        }

        String answer = "";
        mas = inversion(mas, 3);
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++) {

                answer += Float.toString(mas[j][i]);
                answer += " ";
            }
            answer += "\n";
        }
        System.out.println(answer);
        return answer;
    }

    static float [][] inversion(float [][]A, int N)
    {
        double temp;

        float [][] E = new float [N][N];


        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                E[i][j] = 0f;

                if (i == j)
                    E[i][j] = 1f;
            }

        for (int k = 0; k < N; k++)
        {
            temp = A[k][k];

            for (int j = 0; j < N; j++)
            {
                A[k][j] /= temp;
                E[k][j] /= temp;
            }

            for (int i = k + 1; i < N; i++)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int k = N - 1; k > 0; k--)
        {
            for (int i = k - 1; i >= 0; i--)
            {
                temp = A[i][k];

                for (int j = 0; j < N; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = E[i][j];

            return E;
    }
}