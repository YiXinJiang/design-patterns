package com.jyx.test.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName: Controller
 * @Description: 测试
 * @Author: jyx
 * @Date: 2023-11-24 14:45
 * @Version: 1.0
 **/
@RestController
@Slf4j
public class Controller {

    @Autowired
    ConcurrencyService concurrencyService;

    @GetMapping("/run-async")
    public String runAsync(@RequestParam("count") Integer count) {
        List<Integer> collect = IntStream.rangeClosed(1, count).boxed().collect(Collectors.toList());

        for (int i : collect) {
            new Thread(() -> concurrencyService.runAsync(i)).start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                log.error("error", e);
            }
        }
        return "ok";
    }

}
