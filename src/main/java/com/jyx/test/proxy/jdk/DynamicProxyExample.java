package com.jyx.test.proxy.jdk;

import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: DynamicProxyExample
 * @Description:
 * @Author: jyx
 * @Date: 2024-01-05 17:59
 **/
@Configuration
public class DynamicProxyExample {

/*    @Bean
    public MyInterface myInterfaceProxy() {
        MyInterface target = new MyImplementation();
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new CustomInvocationHandler(target));
        return proxy;
    }*/

    /*class CustomInvocationHandler implements InvocationHandler {
        private Object target;
        public CustomInvocationHandler(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println("Method " + method.getName() + " has MyAnnotation with value: " + myAnnotation.value());
                }
            }
            String invoke = (String)method.invoke(target, args);
            return invoke + " handle";
        }
    }*/

}
