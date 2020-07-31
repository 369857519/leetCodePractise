package basics.network.uploadimg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try(
                ServerSocket serverSocket=new ServerSocket(10001);
                Socket server=serverSocket.accept();
                InputStream inputStream=server.getInputStream();
                OutputStream outputStream=server.getOutputStream();
                FileOutputStream fileOutputStream=new FileOutputStream("serverWrite.jpg");
        ){
            int temp=0;
            while((temp=inputStream.read())!=-1){
                fileOutputStream.write(temp);
            }
            server.shutdownInput();
            outputStream.write("上传成功".getBytes());
            server.shutdownOutput();
        }
    }
}
