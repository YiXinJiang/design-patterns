package com.jyx.test.netty.demo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName: NettyClientInitializer
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:20
 **/
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 出站handler，把long型数据解码为字节型
        pipeline.addLast(new ClientLong2ByteEncoder());

        // 入站handler，把字节型数据解码为long型
        pipeline.addLast(new ClientByte2LongDecoder());

        // 添加一个自定义handler（入站），处理业务逻辑
        pipeline.addLast(new NettyClientHandler());
    }
}
