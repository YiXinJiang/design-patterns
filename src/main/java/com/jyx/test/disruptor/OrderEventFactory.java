package com.jyx.test.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @ClassName: OrderEventFactory
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-23 15:11
 **/
public class OrderEventFactory implements EventFactory<OrderEvent> {

    // 这个方法就是为了返回空的数据对象
    @Override
    public OrderEvent newInstance() {
        return new OrderEvent();
    }

}
