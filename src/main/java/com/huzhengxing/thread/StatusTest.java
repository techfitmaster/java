package com.huzhengxing.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

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
            new Thread(() -> {
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


    public void testNewStatus() {
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread.getState().toString());
    }


    public void testRunnableStatus() {
        Thread thread = new Thread(() -> {
        });
        thread.start();
        System.out.println(thread.getState().toString());
    }

    public void testBlockedStatus() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                System.out.println("thread1 run");
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (this) {
                Thread.currentThread().suspend();
            }
        });
        thread2.start();
        thread1.start();
        Thread.sleep(3000);
        System.out.println(thread1.getState().toString());
    }

    public void testWaitingStatus() throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (this) {
                try {
//                    this.wait();
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        );
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState().toString());
    }

    public void testWaitingStatusWithLock() throws InterruptedException {
        Thread thread = new Thread(LockSupport::park);
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState().toString());
    }

    public void testTimeWaitingStatus() throws InterruptedException {
        Thread thread = new Thread(() -> {
//            synchronized (this) {
//                try {
////                    Thread.sleep(2000);
////                    this.wait(2000);
//                    Thread.currentThread().join(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        );
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState().toString());
    }


    public static void main(String[] args) throws InterruptedException {
        StatusTest statusTest = new StatusTest();
//        test();
//        testNewStatus();
//        statusTest.testRunnableStatus();
//        statusTest.testBlockedStatus();
//        statusTest.testWaitingStatus();
//        statusTest.testWaitingStatusWithLock();
        statusTest.testTimeWaitingStatus();
        System.gc();
    }
}
