package com.jyx.test.mq;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: MsgLister
 * @Description: 事件监听器
 * @Author: jyx
 * @Date: 2023-12-13 16:18
 * @Version: 1.0
 **/
@Slf4j
public class MsgListener implements BaseListener {

    @Override
    public void handleMsg(EventObject event) throws RuntimeException {
        log.info("handle msg");
    }
}
