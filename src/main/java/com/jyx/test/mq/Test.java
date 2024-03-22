package com.jyx.test.mq;

/**
 * @ClassName: Test
 * @Description: 测试
 * @Author: jyx
 * @Date: 2023-12-13 16:22
 * @Version: 1.0
 **/
public class Test {

    public static void main(String[] args) {
        // 注册监听器
        Manager.addListener(new MsgListener());
        // 注册监听器
        Manager.addListener(new MsgListener());
        MsgEvent msg = new MsgEvent("test", 11);
        try {
            Manager.sendMsg(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
