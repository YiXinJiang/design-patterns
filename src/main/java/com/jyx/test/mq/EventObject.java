package com.jyx.test.mq;

/**
 * @InterfaceName: EventObject
 * @Description: 事件基类
 * @Author: jyx
 * @Date: 2023-12-13 16:13
 * @Version: 1.0
 **/
public abstract class EventObject {

    private Object source;

    public EventObject(Object source) {
        this.source = source;
    }

    abstract Long getEventId();

}
