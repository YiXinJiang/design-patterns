package com.jyx.test.disruptor;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: OrderEventHandler
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-23 15:12
 **/
@Slf4j
public class OrderEventHandler implements EventHandler<OrderEvent> {

    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
        log.info("handler: {}", Thread.currentThread().getName());
    }

}
