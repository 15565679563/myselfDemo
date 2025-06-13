package org.wlu.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class TestAsync {

    @Async
    public Future<String> test(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture("异步操作结果");
    }

}
