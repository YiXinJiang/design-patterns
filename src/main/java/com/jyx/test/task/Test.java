package com.jyx.test.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: Test
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-27 09:34
 **/
@Slf4j
public class Test {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            run();
        }
    }

    public static void run() throws InterruptedException {
        TaskService taskService = new TaskService();
        ExecutorService executor = Executors.newFixedThreadPool(14);
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executor.submit(taskService::logicLock);
            // executor.submit(taskService::logic);
        }
        executor.shutdown();
        while (!executor.isTerminated()) ;
        log.info("flag: {}", taskService.getFlag());
    }

}
