package com.huzhengxing.socket.upd;

import java.io.IOException;
import java.net.*;

/**
 * @Auther: Albert
 * @Date: 2019/12/4 10:23
 * @Contact: 1092144169@qq.com
 * @Description: UDP客户端
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String message = "客户端发送的消息。。。";
        byte[] bytes = message.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("localhost"), 2222);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
