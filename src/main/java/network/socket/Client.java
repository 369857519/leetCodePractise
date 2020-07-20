package network.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 10006);
        try (DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
             DataInputStream inputStream = new DataInputStream(client.getInputStream())
        ) {
            dataOutputStream.writeUTF("hello lalala");
            System.out.println(inputStream.readUTF());
        }
        client.close();
    }
}
