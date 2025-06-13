package org.wlu.thread;

/**
 * 继承Thread类
 */
public class ExtendThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
