package com.jyx.test.netty.demo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName: NettyServerInitializer
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:18
 **/
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 入站handler，把字节型数据解码为long型
        pipeline.addLast(new ServerByte2LongDecoder2());

        // 出站handler,  把long型数据编码为字节(编码器)
        pipeline.addLast(new ServerLong2ByteEncoder());

        // 添加业务逻辑handler
        pipeline.addLast(new NettyServerHandler());

        System.out.println("NettyServerInitializer.initChannel 执行成功.");
    }
}
