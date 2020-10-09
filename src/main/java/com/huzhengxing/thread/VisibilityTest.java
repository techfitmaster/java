package com.huzhengxing.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 2020/9/27 16:58  zhengxing.hu
 * @version 1.0.0
 * @file VisibilityTest
 * @brief
 * @par
 * @warning
 * @par 杭州锘崴信息科技有限公司版权所有©2020版权所有
 */
public class VisibilityTest {
    int i = 0;
    /**
     * 解决jvm指令重排，不可见问题
     * 不能被cpu高级缓存
     *
     *
     */
    volatile boolean bol = true;

    public void testVisibility() throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            System.out.println("thread running...");
            while (bol) {
                i++;
            }
            System.out.println("i => " + i);
        }).start();
        Thread.sleep(3000);
        bol = false;
        System.out.println("done.");


    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest visibilityTest = new VisibilityTest();
        visibilityTest.testVisibility();

    }
}
