package com.jyx.test.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @ClassName: NettyReplyHandler
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:05
 **/
public class NettyReplyHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {



    }
}
