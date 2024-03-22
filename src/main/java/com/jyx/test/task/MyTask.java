package com.jyx.test.task;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: MyTask
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-27 09:35
 **/
@Slf4j
public class MyTask implements Runnable {

    private TaskService taskService;

    public MyTask(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run() {
        // log.info("task is running");
        taskService.logic();
    }
}
