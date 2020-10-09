package com.huzhengxing.thread;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 2020/9/28 14:29  zhengxing.hu
 * @version 1.0.0
 * @file AtomicTest
 */
public class AtomicTest {

    volatile int i = 0;

    AtomicInteger atomicInteger = new AtomicInteger(0);


    public synchronized void add() {
//        i++;
        atomicInteger.getAndIncrement();
    }

    public void testAdd() throws InterruptedException {
        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    add();
                }
            }).start();
        }

        Thread.sleep(3000L);
        System.out.println(atomicInteger.get());
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicTest atomicTest = new AtomicTest();
        atomicTest.testAdd();

    }
}
