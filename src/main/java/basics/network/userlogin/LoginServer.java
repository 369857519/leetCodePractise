package basics.network.userlogin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(10001);
        ) {
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(()->{
                    try(InputStream inputStream = socket.getInputStream();
                        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);){
                        User obj = (User) objectInputStream.readObject();
                        System.out.println(obj);
                        socket.shutdownInput();
                        dataOutputStream.writeUTF("success");
                        socket.shutdownOutput();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                },"login thread").start();

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }


    }
}
