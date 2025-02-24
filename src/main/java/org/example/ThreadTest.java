package org.example;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 交替打印1到200
 */
public class ThreadTest {

    public static void main(String[] args) {

        //test1();

        test2();

    }

    /**
     * 使用标志位来标记执行哪个线程
     * 知识点：线程安全原子操作
     */
    public static void test1() {
        AtomicInteger i = new AtomicInteger(1);
        AtomicBoolean flag = new AtomicBoolean(true);
        new Thread(() -> {
            while (i.get() <= 200) {
                if (flag.get()) {
                    System.out.println(Thread.currentThread().getName() + ":" + i.getAndIncrement());
                    flag.set(false);
                }

            }

        }).start();

        new Thread(() -> {
            while (i.get() <= 200) {
                if (!flag.get()) {
                    System.out.println(Thread.currentThread().getName() + ":" + i.getAndIncrement());
                    flag.set(true);
                }
            }
        }).start();
    }

    /**
     * 使用synchronized对obj对象加锁，同时使用线程阻塞实现线程交替打印
     */
    public static void test2() {
        AtomicInteger i = new AtomicInteger(1);
        Object obj = new Object();
        new Thread(() -> {
            synchronized (obj) {
                while (i.get() <= 200) {
                    while (i.get() % 2 != 1) { // 条件检查
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i.getAndIncrement());
                    obj.notify(); // 唤醒线程2
                }
            }
        }).start();
        // 线程2：打印偶数
        new Thread(() -> {
            synchronized (obj) {
                while (i.get() <= 200) {
                    while (i.get() % 2 != 0) { // 条件检查
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i.getAndIncrement());
                    obj.notify(); // 唤醒线程1
                }
            }
        }).start();
    }

}