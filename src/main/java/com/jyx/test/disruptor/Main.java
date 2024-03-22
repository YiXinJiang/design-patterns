package com.jyx.test.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: Main
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-23 15:13
 **/
@Slf4j
public class Main {

    public static void main(String[] args) {

        log.info("main: {}", Thread.currentThread().getName());

        // 1.实例化disruptor对象
        OrderEventFactory orderEventFactory = new OrderEventFactory();

        int ringBufferSize = 1024 * 1024;

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                orderEventFactory,          // 消息（event）工厂对象
                ringBufferSize,             // 容器的长度
                executor,                   // 线程池（建议使用自定义线程池）
                ProducerType.SINGLE,        // 单生产者模式
                new BlockingWaitStrategy()  // 等待策略，这里用的阻塞的策略
        );

        // 2.添加消费者监听(构建disruptor与消费者的关系)
        disruptor.handleEventsWith(new OrderEventHandler(), new OrderEventHandler1());

        // 3.启动disruptor
        disruptor.start();

        // 4. 获取实际存储数据的容器： RingBuffer
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer producer = new OrderEventProducer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (int i = 0; i < 3; i++) {
            bb.putLong(0, i);
            producer.sendData(bb);
        }
        disruptor.shutdown();
        executor.shutdown();
    }

}


