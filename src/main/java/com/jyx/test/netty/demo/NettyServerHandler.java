package com.jyx.test.netty.demo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName: NettyServerHandler
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:19
 **/
public class NettyServerHandler extends SimpleChannelInboundHandler<Long> {
    // 被调用多次
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("从客户端" + ctx.channel().remoteAddress() + "读取到long" + msg);
        // 给客户端回送消息
        // ctx.writeAndFlush(98765L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
