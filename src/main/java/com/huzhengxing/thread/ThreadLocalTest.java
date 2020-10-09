package com.huzhengxing.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 2020/9/25 17:22  zhengxing.hu
 * @version 1.0.0
 * @file ThreadLocalTest
 * @brief
 * @par
 * @warning
 * @par
 */
public class ThreadLocalTest {

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(ThreadLocalTest.get());
            ThreadLocal<String> integerThreadLocal = ThreadLocal.withInitial(() -> "123");
            System.out.println(integerThreadLocal.get());
            integerThreadLocal.set("12312");
            System.out.println(integerThreadLocal.get());
        });
        thread.start();
        new Thread(()->{
            System.out.println(ThreadLocalTest.get());
        }).start();
        new Thread(()->{
            System.out.println(ThreadLocalTest.get());
        }).start();



    }
}
