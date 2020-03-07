package com.huzhengxing.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther: Albert
 * @Date: 2019/12/4 11:24
 * @Contact: 1092144169@qq.com
 * @Description:TCP客户端
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3333);
        OutputStream outputStream = socket.getOutputStream();
        String message = "客户端发送消息";
        outputStream.write(message.getBytes());
        outputStream.close();
    }
}
