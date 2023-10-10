import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket sc = serverSocket.accept();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        sc.getInputStream()
                )
        );

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        sc.getOutputStream()
                )
        );

        String messageFromClient = reader.readLine();

        System.out.println(messageFromClient);


        String[] messages = messageFromClient.split(" ");

        String message = "Walikum Salam " + messages[messages.length - 1];
        writer.write("Server: " + message);

        writer.newLine();
        writer.flush();

        sc.close();
    }
}
