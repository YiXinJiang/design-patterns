package com.jyx.test.chain;

/**
 * @InterfaceName: Handler
 * @Description: 处理器接口
 * @Author: jyx
 * @Date: 2023-12-25 16:22
 **/
public interface Handler<T extends BaseRequest> {

    void handler(T request);

}
