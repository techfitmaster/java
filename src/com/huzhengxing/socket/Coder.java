package com.huzhengxing.socket;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Albert
 * @Date: 2019/12/4 18:38
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class Coder {

    private int packHead = 95;

    /**
     * 解码
     * @param bytes
     * @return
     */
    public List<byte[]> decode(byte [] bytes) {
        boolean packHeadFind = false;
        int packHeadIndex = 0;
        int packEndIndex = 0;
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (packHeadFind) {
                //判断是否是包描述
               if (i - packHeadIndex == 1) {
                   int packType = b >> 6;


               }


            }


            //获取包头

            if (b == packHead) {
                packHeadFind = true;
                packHeadIndex = i;
            }


            //查询包长度

        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {

        byte[] data = new byte[1024];
        int length = data[0];
        Byte byData = data[1];
        for (int i = 0; i < length; i++) {
            int state = 0;
            if (i == 0) {
                state = (byData & 0x01) == 0x01 ? 1 : 0;
            } else if (i == 1) {
                state = (byData & 0x02) == 0x02 ? 1 : 0;
            } else if (i == 2) {
                state = (byData & 0x04) == 0x04 ? 1 : 0;
            } else if (i == 3) {
                state = (byData & 0x08) == 0x08 ? 1 : 0;
            }
        }
        byte c = (byte) 96>>5;
        System.out.println(c);


    }
}
