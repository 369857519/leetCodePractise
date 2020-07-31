package basics.network.userlogin;

import java.io.*;
import java.net.Socket;

public class LoginClient {
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("localhost", 10001);
             OutputStream outputStream = client.getOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
             DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        ) {
            User user = new User("lalala", "hahaha");
            objectOutputStream.writeObject(user);
            client.shutdownOutput();
            String res = "";
            do {
                res = dataInputStream.readUTF();
                client.shutdownInput();
                System.out.println(res);
            }while(res.length()>0&&!client.isInputShutdown());
        }
    }
}
