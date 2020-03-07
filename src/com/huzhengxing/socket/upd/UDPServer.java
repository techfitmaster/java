package com.huzhengxing.socket.upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Auther: Albert
 * @Date: 2019/12/3 20:18
 * @Contact: 1092144169@qq.com
 * @Description: UDP服务端
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("UDP服务器开启。。。");
        //开启一个udp服务器
        DatagramSocket datagramSocket = new DatagramSocket(2222);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //接收客户端发送的消息 处于阻塞状态
        System.out.println("等待客户端发送消息。。。");
        datagramSocket.receive(datagramPacket);
        System.out.println("接收服务端发送的消息:" + new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        datagramSocket.close();
    }
}
