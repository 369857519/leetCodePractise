package basics.network.uploadimg;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("OIP.jpg");
                Socket client = new Socket("localhost", 10001);
                OutputStream outputStream = client.getOutputStream();
                InputStream inputStream = client.getInputStream();
        ) {
            int temp = 0;
            while ((temp = fileInputStream.read()) != -1) {
                outputStream.write(temp);
            }
            //添加流输出完成的标志，必须手动关闭流
            client.shutdownOutput();

            byte[] buf = new byte[1024];
            int length = inputStream.read(buf);
            //输入完成标志，必须手动关闭流
            client.shutdownInput();
            System.out.println(new String(buf, 0, length));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
