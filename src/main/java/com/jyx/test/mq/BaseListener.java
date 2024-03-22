package com.jyx.test.mq;

/**
 * @InterfaceName: MsgListener
 * @Description: 监听器
 * @Author: jyx
 * @Date: 2023-12-13 16:17
 * @Version: 1.0
 **/
public interface BaseListener<T extends EventObject> {

    void handleMsg(T event);

}
