package com.huzhengxing.thread;

/**
 * @author 2020/9/24 18:04  zhengxing.hu
 * @version 1.0.0
 * @file StopTest
 * @brief
 * @par
 * @warning
 * @par
 */
public class StopTest {

    private int i = 0;
    private int j = 0;

    public void testStopThread() throws InterruptedException {

        Thread thread = new Thread(() -> {
//            while (true) {
//
//
//            }

            synchronized (this) {
                i++;

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                j++;


            }

        });
        thread.start();

        Thread.sleep(3000);
        thread.stop();

//        thread.interrupt();

        Thread.sleep(3000);

        System.out.println("i = " + i + ", j = " + j);

    }


    public static void main(String[] args) throws InterruptedException {
        StopTest stopTest = new StopTest();
        stopTest.testStopThread();

    }
}
