package com.jyx.test.disruptor;

import com.lmax.disruptor.RingBuffer;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @ClassName: OrderEventProducer
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-23 15:12
 **/
@Slf4j
public class OrderEventProducer {

    private RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(ByteBuffer data) {
        log.info("producer: {}", Thread.currentThread().getName());
        // 1.在生产者发送消息的时候，首先需要从我们的ringBuffer里面获取一个可用的序号
        long sequence = ringBuffer.next();
        try {
            // 2.根据这个序号找到具体的"OrderEvent" 元素,此时获取的对象没有被赋值
            OrderEvent event = ringBuffer.get(sequence);
            // 3.进行实际的赋值处理
            event.setValue(data.getLong(0));
        } finally {
            // 4.提交发布操作
            ringBuffer.publish(sequence);
        }
    }

}
