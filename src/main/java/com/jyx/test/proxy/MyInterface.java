package com.jyx.test.proxy;

/**
 * @InterfaceName: MyInterface
 * @Description:
 * @Author: jyx
 * @Date: 2024-01-05 17:58
 **/
public interface MyInterface {
    @MyAnnotation("Hello")
    String myMethod(int i);
}
