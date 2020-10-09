package com.huzhengxing.thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.locks.LockSupport;

/**
 * 多线程通信的几种方式
 * 1. 文件共享
 * 2. 变量共享
 * 3. 网络共享(通过HTTP请求)
 * 4. JDK API
 */
public class CommunicationTest {

    private int i = 0;

    /**
     * 通过文件方式进行通信
     */
    public void testMethodOfFile() {


        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    Files.write(Paths.get("method_of_file.txt"), String.valueOf(i++).getBytes());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {
            while (true) {
                byte[] bytes = new byte[0];
                try {
                    Thread.sleep(4000);
                    bytes = Files.readAllBytes(Paths.get("method_of_file.txt"));
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(bytes));
            }
        }).start();
    }


    private String var = "";

    /**
     * 通过共享变量方式
     */
    public void testMethodOfVariable() {

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var = "helle -> " + i++;
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(var);
            }
        }).start();

    }


    private String message = null;

    /**
     * 测试 suspend 和 resume
     */
    public void testsSuspendAndResume() {

        Thread consumer = new Thread(() -> {

            while (true) {
                while (message == null) {
                    System.out.println("等待接受消息");
                    Thread.currentThread().suspend();
                }
                System.out.println("接受消息 => " + message);
                message = null;
            }

        });
        consumer.start();

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    message = "Hello , this is " + i++;
                    consumer.resume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
    }

    /**
     * 测试Suspend Resume 死锁
     * <p>
     * 1. Resume方法比Suspend方法先执行
     */
    public void testSuspendAndResumeDeadLockOfSync() {
        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    while (message == null) {
                        System.out.println("等待接受消息");
                        Thread.currentThread().suspend();
                    }
                    System.out.println("接受消息 => " + message);
                    message = null;
                }
            }
        });
        consumer.start();

        Thread producer = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    try {
                        Thread.sleep(3000);
                        message = "Hello , this is " + i++;
                        consumer.resume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        producer.start();
    }


    /**
     * 测试Suspend Resume 因为执行顺序死锁
     * <p>
     * 1. 使用synchronized,且是同一个锁
     * 2. suspend方法不会释放锁，导致producer一直在获取锁
     */
    public void testSuspendAndResumeDeadLockOfExecuteOrder() {
        Thread consumer = new Thread(() -> {

//            while (true) {
            while (message == null) {
                System.out.println("等待接受消息");
                try {
                    Thread.sleep(4000);
                    Thread.currentThread().suspend();

//                    Thread.sleep(6000);
//                    Thread.currentThread().suspend();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("接受消息 => " + message);
            message = null;

//            }

        });
        consumer.start();

        Thread producer = new Thread(() -> {
//            while (true) {
            try {
                Thread.sleep(3000);
                message = "Hello , this is " + i++;
                consumer.resume();

                Thread.sleep(2000);
                consumer.resume();
                consumer.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            }
        });
        producer.start();
    }


    public void testNotify() {

        Thread thread1 = new Thread(() -> {

            synchronized (this) {
                try {
                    this.wait();
                    System.out.println("thread 1 awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (this) {
                try {
                    this.wait();
                    System.out.println("thread 2 awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            synchronized (this) {
                try {
                    this.wait();
                    System.out.println("thread 3 awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        try {
            Thread.sleep(2000);
            synchronized (this) {
                this.notify();
                this.notify();
                System.out.println("已经调用唤醒方法，证明被唤醒的线程只有等待当前线程获取到锁之后才能进行");
                Thread.sleep(3000);
//                this.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void testWaitAndNotify() {

        Thread consumer = new Thread(() -> {

            while (true) {
                synchronized (this) {
                    while (message == null) {
                        System.out.println("等待接受消息");
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("接受消息 => " + message);
                    message = null;
                }
            }
        });

        consumer.start();

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    message = "Hello , this is " + i++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    this.notifyAll();
                }

            }
        });

        producer.start();
    }


    public void testParkAndUnPark() {
        Thread consumer = new Thread(() -> {

            while (message == null) {
                System.out.println("等待接受消息");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.park();
            }
            System.out.println("接受消息 => " + message);
            message = null;
        });

        consumer.start();

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(3000);
                message = "Hello , this is " + i++;
                LockSupport.unpark(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                this.notifyAll();
            }

        });

        producer.start();
    }


    public void testWaitAndNotifyDeadBlockOfExecteOrder() {

        Thread consumer = new Thread(() -> {

            while (true) {
                while (message == null) {
                    System.out.println("等待接受消息");
                    try {
                        Thread.sleep(3000);
                        synchronized (this) {
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("接受消息 => " + message);
                message = null;

            }
        });

        consumer.start();

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000);
                message = "Hello , this is " + i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                this.notifyAll();
            }
        });

        producer.start();
    }


    public static void main(String[] args) {
        CommunicationTest communicationTest = new CommunicationTest();
//        communicationTest.testMethodOfFile();
//        communicationTest.testMethodOfVariable();
//        communicationTest.testsSuspendAndResume();
//        communicationTest.testSuspendAndResumeDeadLockOfSync();
//        communicationTest.testSuspendAndResumeDeadLockOfExecuteOrder();
//        communicationTest.testWaitAndNotify();
//        communicationTest.testWaitAndNotifyDeadBlockOfExecteOrder();
//        communicationTest.testNotify();
        communicationTest.testParkAndUnPark();

    }


}
