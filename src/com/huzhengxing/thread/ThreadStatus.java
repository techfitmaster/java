package com.huzhengxing.thread;

/**
 * @Auther: Albert
 * @Date: 2019/11/22 19:34
 * @Contact: 1092144169@qq.com
 * @Description: 线程状态
 */
public class ThreadStatus {


    public static void main(String[] args) {

        //初始状态
        Thread thread = new Thread(()->{
            while (true){


//                System.out.println("i am run");
            }
        });
        Thread thread1 = new Thread(() -> {
            while (true){
                try {
                    printState(thread,"thread状态:");
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

//        thread1.start();
        printState(thread,"before start:");
        //可运行状态
        thread.start();
        printState(thread,"after start:");
//
//        try {
//            thread.sleep(10000);
//            printState(thread,"after join:");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }




    }
    private static void printState(Thread thread,String message) {
        System.out.println(message + thread.getState());
    }




}
