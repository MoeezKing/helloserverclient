import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("localhost", 1234);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        sc.getOutputStream()
                )
        );

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        sc.getInputStream()
                )
        );

        String message = "Hello My name is uzair";

        writer.write("Client " + message);
        writer.newLine();
        writer.flush();

        String messageFromServer = reader.readLine();
        System.out.println(messageFromServer);

        sc.close();
    }
}
