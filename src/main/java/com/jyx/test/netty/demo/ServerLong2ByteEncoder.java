package com.jyx.test.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName: MyLong2ByteEncoder
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:23
 **/
public class ServerLong2ByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("server --> encode编码");
        out.writeLong(msg);
    }
}
