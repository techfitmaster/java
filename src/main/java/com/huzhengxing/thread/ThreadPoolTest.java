package com.huzhengxing.thread;

import java.util.concurrent.*;

/**
 * @author 2020/9/27 14:11  zhengxing.hu
 * @version 1.0.0
 * @file ThreadPoolTest
 * @brief 线程池原理解析测试
 * @par
 * @warning
 * @par
 */
public class ThreadPoolTest {


    public void executeTask(ThreadPoolExecutor threadPoolExecutor) {
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println("execute task before => " + finalI + "，execute time => " + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("execute task after => " + finalI + "，execute time => " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("submit succeed :" + finalI);
        }

        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------------- ");
            System.out.println("queue size : " + threadPoolExecutor.getQueue().size());
            System.out.println("active count : " + threadPoolExecutor.getActiveCount());
            System.out.println("completed count : " + threadPoolExecutor.getCompletedTaskCount());
            System.out.println("pool size : " + threadPoolExecutor.getPoolSize());
            System.out.println("------------------------- ");
        } while (threadPoolExecutor.getActiveCount() > 0);
    }

    private void testExecutors() {
//        ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
//        executeTask(fixedThreadPool);

//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        executeTask((ThreadPoolExecutor) cachedThreadPool);

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(15);
//        executeTask((ThreadPoolExecutor) scheduledExecutorService);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            singleThreadExecutor.submit(() -> {
                try {
                    System.out.println("execute task before => " + finalI + "，execute time => " + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("execute task after => " + finalI + "，execute time => " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("submit succeed :" + finalI);

        }
    }


    /**
     * 执行流程
     * <p>
     * 核心线程数 -> 队列数 -> 最大线程数 -> 执行策略
     *
     * @return
     */
    public ThreadPoolExecutor testThreadPoolExecutor() {


        return new ThreadPoolExecutor(4,
                6,
                1,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(4),
                new ThreadPoolExecutor.DiscardPolicy()
        );

    }

    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
//        threadPoolTest.executeTask(threadPoolTest.testThreadPoolExecutor());

        threadPoolTest.testExecutors();


    }
}
