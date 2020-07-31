package basics.network.udpsocket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(10000);
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        DatagramPacket datagramPacket=new DatagramPacket(str.getBytes(),str.getBytes().length,
                InetAddress.getByName("localhost"),10001);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
