package basics.network.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(10001);
        byte[] buf=new byte[1024];


        DatagramPacket datagramPacket=new DatagramPacket(buf,buf.length);
        datagramSocket.receive(datagramPacket);

        System.out.printf(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
