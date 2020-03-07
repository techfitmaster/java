package com.huzhengxing.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Auther: albert
 * @Date: 2019-02-23 15:05
 * @Description:
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private static final int ID = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + ID + "-" + (countDown > 0 ? countDown : "LiftOff");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            //提示这个线程可以被忽略 ，这个方法一般在测试或者debug中使用
            Thread.yield();
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
    }
}

class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}

/**
 * 固定线程个数
 */
class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 6; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}


class SingleThreadPool{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

}

class TaskWithResult implements Callable<String>{

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return  "Result of id => " + id;
    }
}

class CallableDemo{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }

        futures.forEach(future-> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println(e);
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }

        });
    }
}


class SimplePriorities implements Runnable{

    private int dountDown = 5;
    private volatile  double d;

    @Override
    public void run() {

    }
}
