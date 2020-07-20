package network.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(10006);
        Socket server = serverSocket.accept();
        try (DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
             DataOutputStream dataOutputStream=new DataOutputStream(server.getOutputStream());
        ) {
            System.out.printf(dataInputStream.readUTF());
            Thread.sleep(1000);
            dataOutputStream.writeUTF("hello rua rua rua");
        }
    }
}
