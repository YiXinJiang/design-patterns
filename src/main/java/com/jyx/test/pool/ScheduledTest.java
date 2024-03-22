package com.jyx.test.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ScheduledTest
 * @Description: 测试
 * @Author: jyx
 * @Date: 2023-11-24 14:55
 * @Version: 1.0
 **/
@Component
public class ScheduledTest {

    @Autowired
    ConcurrencyService concurrencyService;

    @Scheduled(cron = "*/2 * * * * ?")
    public void test() {
        // concurrencyService.runSimple();
        // concurrencyService.runAsync(2);
    }

}
