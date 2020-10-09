package com.huzhengxing.thread;

/**
 * @Auther: Albert
 * @Date: 2019/11/23 16:43
 * @Contact: 1092144169@qq.com
 * @Description: 守护进程测试
 *  线程分类：
 *      1. 用户线程
 *      2. 守护线程
 *  what:  守护线程伴随着用户线程的存在而存在，如果没有用户线程，守护线程也会自动关闭
 *  where: 守护线程最典型的应用就是 GC (垃圾回收器)
 *  why: 可以控制其他线程的退出，比如单独开启一个线程做定时任务，然后我程序已经执行完关闭退出了，不需要这个定时任务了。这时候就需要守护线程
 *
 *  how: Thead.setDaemon(true)
 */
public class DaemonTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (true){
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("thread1 out");
            }

        });
        thread1.setDaemon(true);
        thread1.start();
        thread1.interrupt();
        System.out.println(thread1.getState().toString());
        try {
            //当运行到4秒后，thread1线程也会结束，java虚拟机会停止工作
            Thread.sleep(4000);
            System.out.println("main thread out ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
