package com.jyx.test.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OderService
 * @Description: 订单服务
 * @Author: jyx
 * @Date: 2024-01-22 15:15
 **/
@Slf4j
@Service
public class OrderService {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void createOrder(Order order) {
        log.info("publish create event. {}", Thread.currentThread().getName());
        OrderCreateEvent event = new OrderCreateEvent(this, order);
        // .builder().order(order).build()
        publisher.publishEvent(event);
    }

}
