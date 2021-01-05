package com.huzhengxing.oom;

/**
 * @author 2020/10/27 16:33  zhengxing.hu
 * @version 1.0.0
 * @file JavaVMStackSOF
 * @brief 通过 -Xss128k 设置栈的大小
 * @par
 * @warning
 * @par 杭州锘崴信息科技有限公司版权所有©2020版权所有
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
       stackLength++;
       stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        javaVMStackSOF.stackLeak();
//        System.gc();
    }
}
