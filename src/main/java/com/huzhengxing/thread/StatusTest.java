package com.huzhengxing.thread;

/**
 * @author 2020/9/24 16:50  zhengxing.hu
 * @version 1.0.0
 * @file StatusTest
 * 线程状态测试
 * @brief
 * @par
 * @warning
 * @par
 */
public class StatusTest {


    /**
     *
     */
    private static void test() {

        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(3000);

                synchronized (DaemonTest.class) {

                }
                while (true) {

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        System.out.println("Must be new -> " + thread.getState().toString());

        thread.start();

        System.out.println("Must be runnable -> " + thread.getState().toString());

        new Thread(() -> {
            synchronized (DaemonTest.class) {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        try {
//            thread.wait();

//            System.out.println("Must be  waiting -> " + thread.getState().toString());


//            System.out.println("Must be time waiting -> " + thread.getState().toString());

            Thread.sleep(4000);
            System.out.println("Must be blocked -> " + thread.getState().toString());

            Thread.sleep(2000);
            new Thread(()->{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Must be wait -> " + thread.getState().toString());

            }).start();
            synchronized (thread) {
                thread.wait();
            }
            thread.stop();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
