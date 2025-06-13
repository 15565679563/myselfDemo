package org.wlu.test;

import java.util.concurrent.*;

public class test {

    public static final int i = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟耗时操作
                System.out.println("田螺CompletableFuture开启异步：" + Thread.currentThread().getName());
                return "Hello, 公众号：捡田螺的小男孩!";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, 公众号：捡田螺的小男孩!";
        }, executor);
        future.thenAccept(result -> System.out.println("异步结果：" + result));
        future.join();
    }



}

