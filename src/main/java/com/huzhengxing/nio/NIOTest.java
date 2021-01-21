package com.huzhengxing.nio;


import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @Auther: Albert
 * @Date: 2019/12/5 18:49
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class NIOTest {

    public void testByteBuffer(){
        //射仪容量为1024字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //给缓冲区放入字节
        byteBuffer.put("1234567890".getBytes());

        //获取缓冲区内容
        //position 设置为0, limit 设置为position的值
        byteBuffer.flip();
        //设置缓冲区字节大小的数组
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println("缓冲区内容:" + new String(bytes,0,bytes.length));
        byteBuffer.rewind();
        byteBuffer.clear();
        byteBuffer.mark();
        byteBuffer.reset();

        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(1024);

        ArrayList<Object> objects = new ArrayList<>();

    }


    public void testFileChannel(){


    }

}
