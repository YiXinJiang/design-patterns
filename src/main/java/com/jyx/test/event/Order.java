package com.jyx.test.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Order
 * @Description: 订单信息
 * @Author: jyx
 * @Date: 2024-01-22 15:13
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private Long id;

    private String serial;

}
