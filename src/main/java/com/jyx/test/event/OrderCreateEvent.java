package com.jyx.test.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @ClassName: OrderCreateEvent
 * @Description: 订单创建事件
 * @Author: jyx
 * @Date: 2024-01-22 15:12
 **/
public class OrderCreateEvent extends ApplicationEvent {

    @Getter
    public Order order;

    public OrderCreateEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }

    public OrderCreateEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
