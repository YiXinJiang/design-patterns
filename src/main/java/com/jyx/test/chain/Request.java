package com.jyx.test.chain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Request
 * @Description: 请求
 * @Author: jyx
 * @Date: 2023-12-25 16:22
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request implements BaseRequest {

    /**
     * 事件类型
     */
    private String requestType;

    /**
     * 事件上下文
     */
    private Object requestContent;

}
