package com.huzhengxing.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: Albert
 * @Date: 2019/12/4 10:30
 * @Contact: 1092144169@qq.com
 * @Description: TCP服务端
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        //获取客户端字节流
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String message = new String(bytes, 0, read);
        System.out.println("接收到客户端发送的消息:" + message);
        serverSocket.close();
    }


}
