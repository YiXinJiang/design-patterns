package com.jyx.test.proxy.cglib;

import com.jyx.test.proxy.MyInterface;
import net.sf.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyInterfaceConfig
 * @Description:
 * @Author: jyx
 * @Date: 2024-01-08 09:50
 **/
@Configuration
public class MyInterfaceConfig {
    @Bean
    public MyInterface myInterfaceProxy(CustomMethodInterceptor customMethodInterceptor) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Object.class);
        enhancer.setInterfaces(new Class[]{MyInterface.class});
        enhancer.setCallback(customMethodInterceptor);
        return (MyInterface) enhancer.create();
    }
}
