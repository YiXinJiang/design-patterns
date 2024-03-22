package com.jyx.test.features;

/**
 * @ClassName: Service
 * @Description:
 * @Author: jyx
 * @Date: 2024-01-24 09:59
 **/
public class Service {
    public void test() {
        String str = "say";
        MyInterface myInterface = msg -> System.out.println("Hello " + msg);
        myInterface.say(str);
    }
}
