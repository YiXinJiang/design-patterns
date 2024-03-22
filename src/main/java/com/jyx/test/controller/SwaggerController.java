package com.jyx.test.controller;

//import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-01 10:42
 **/
//@Api("测试控制器")
@RestController
public class SwaggerController {

    @GetMapping("/token/{code}")
    public String tokenInfo(@PathVariable String code) throws Exception {

        return "result";
    }

}
