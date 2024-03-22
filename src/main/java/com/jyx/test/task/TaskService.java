package com.jyx.test.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: TaskService
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-27 09:37
 **/
@Slf4j
public class TaskService {
    private int flag = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void logic() {
        flag++;
    }

    public void logicLock() {
        lock.lock();
        flag++;
        lock.unlock();
    }

    public int getFlag() {
        return flag;
    }
}
