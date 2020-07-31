package basics.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWorkTest {
    public static void main(String[] args) throws UnknownHostException {
        /*
        基本要素：
            IP 地址
            端口号：0-1024 计算机保留、有效0-65535
            通信协议：TCP、UDP
         OSI（七层模型）:
            应用层 表示层 会话层 传输层 网络层 数据链路层 物理层
         TCP/IP参考协议：
            应用层 传输层 网络层 网络接口（链路+物理）
         lvs
         nginx
         IP地址：
            32位，由4个8位二进制数组组成
            IP地址分类：用户主要用B、C、D，国内主要用D类
                A:1-126 B:128-191 C:192-223 D:224-239
             255.255.255.255 广播地址，当前子网广播
         */
        InetAddress inetAddress=InetAddress.getLocalHost();
        System.out.println(inetAddress);
        InetAddress inetAddress1=InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress1);
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());

        /*
        UDP 相当于发短信，不需要建立连接，数据包大小限制在64k，效率搞，不安全，容易丢包
        TCP 三次握手，四次分手，相当于打电话，需要建立连接，数据相对安全
        SOCKET 两个程序建立双向通道实现数据交换，Java提供Socket api。
         */
    }
}
