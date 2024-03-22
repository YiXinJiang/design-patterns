package com.jyx.test.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: OrderCreatedEventListener
 * @Description: 订单事件监听
 * @Author: jyx
 * @Date: 2024-01-22 15:18
 **/
@Slf4j
@Component
public class OrderCreatedEventListener {

    @EventListener
    public void handleOrderCreateEvent(OrderCreateEvent createEvent) throws InterruptedException {
        log.info("handle create event on OrderCreatedEventListener. {}", Thread.currentThread().getName());
        Order order = createEvent.getOrder();
        log.info("order in one: {}", order);

        Object source = createEvent.getSource();
        log.info("source: {}", source);
        Thread.sleep(2000L);
    }

}
