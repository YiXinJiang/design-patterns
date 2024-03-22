package com.jyx.test.mq;

import java.io.Serializable;

/**
 * @ClassName: MsgEvent
 * @Description: 具体事件
 * @Author: jyx
 * @Date: 2023-12-13 16:14
 * @Version: 1.0
 **/
public class MsgEvent extends EventObject implements Serializable {

    @Override
    public Long getEventId() {
        return null;
    }

    private int status;

    public MsgEvent(Object source) {
        super(source);
    }

    public MsgEvent(Object source, int status) {
        super(source);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
