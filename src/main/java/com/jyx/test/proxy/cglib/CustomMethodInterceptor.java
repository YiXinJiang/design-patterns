package com.jyx.test.proxy.cglib;

import com.jyx.test.proxy.MyAnnotation;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName: CustomMethodInterceptor
 * @Description:
 * @Author: jyx
 * @Date: 2024-01-08 09:59
 **/
@Component
public class CustomMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("Method " + method.getName() + " has MyAnnotation with value: " + myAnnotation.value());
            }
        }
        return "-----------------";
    }
}
