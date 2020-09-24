package com.huzhengxing.thread;

/**
 * @Auther: Albert
 * @Date: 2019/11/23 16:43
 * @Contact: 1092144169@qq.com
 * @Description: 守护进程测试
 *
 *  当只有守护线程在运行时，java虚拟机会退出
 *
 *
 *
 */
public class DaemonTest {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 run ");
            }

        });
        thread1.setDaemon(true);
        thread1.start();
        try {
            //当运行到4秒后，thread1线程也会结束，java虚拟机会停止工作
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
