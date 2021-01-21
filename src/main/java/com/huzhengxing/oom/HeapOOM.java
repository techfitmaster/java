package com.huzhengxing.oom;

import java.util.ArrayList;

/**
 * @author 2020/10/27 16:24  zhengxing.hu
 * @version 1.0.0
 * @file HeapOOM
 * @brief 通过 -Xms20 -Xmx20 设置堆大小
 * @par
 * @warning
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        String str = "";
        while (true) {
            str += "222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222";
        }
    }
}
