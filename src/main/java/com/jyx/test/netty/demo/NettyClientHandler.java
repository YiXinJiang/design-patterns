package com.jyx.test.netty.demo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName: NettyClientHandler
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:21
 **/
public class NettyClientHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("得到服务器ip = " + ctx.channel().remoteAddress());
        System.out.println("收到服务器消息 = " + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClientHandler 在管道激活时发送数据");
        // 1 分析
        // 1.1 abcdefgabcdefgab 是16个字节， long型占8个字节，所以服务器需要解码2次，每次解码8个字节
        // 1.2 该处理器的前一个handler是 MyLong2ByteEncoder，
        // 1.3 MyLong2ByteEncoder 的父类是  MessageToByteEncoder
        // 1.4 MessageToByteEncoder.write()方法通过acceptOutboundMessage判断当前msg是否为要处理的数据类型；
        //     若不是，则跳过encode方法， 否则执行对应的encode 方法（处理方法）

        // 客户端发送一个ByteBuf，不走Long型编码器
        ctx.writeAndFlush(Unpooled.copiedBuffer("abcdefgabcdefgab", StandardCharsets.UTF_8));
        // 客户端发送一个Long，走Long型编码器
//        ctx.writeAndFlush(123456L); // 发送一个long
    }
}
