package com.jyx.test.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ConcurrencyService
 * @Description: 测试
 * @Author: jyx
 * @Date: 2023-11-24 14:44
 * @Version: 1.0
 **/
@Slf4j
@Service
public class ConcurrencyService {

    @Async("threadPoolExecutorCpu")
    public void runAsync(Integer id) {
        log.info("start:{},num:{}", Thread.currentThread().getId(), id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("end:{},num:{}", Thread.currentThread().getId(), id);
    }

    public void run(Integer id) {
        this.runAsync(id);
    }

    public void runSimple() {
        log.info("runSimple:{}", Thread.currentThread().getId());
    }

}
