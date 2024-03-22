package com.jyx.test.disruptor;

import lombok.Data;

/**
 * @ClassName: OrderEvent
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-23 15:11
 **/
@Data
public class OrderEvent {

    // 订单的价格
    private long value;

}
