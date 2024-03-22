package com.jyx.test.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName: MyByte2LongDecoder
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:21
 **/
public class ClientByte2LongDecoder extends ByteToMessageDecoder {

    /**
     * @param ctx 处 理器上下文
     * @param in  字节输入缓冲
     * @param out 集合，把处理后的数据传给下一个 ChannelInboundHandler
     * @return
     * @description decode 会根据接收的数据，被调用多次，直到确定没有新元素被添加到list为止， 或者 ByteBuf没有更多的可读字节为止；
     * 如果list out 不为空，就会将list的内容传递给下一个 ChannelInboundHandler，
     * 且下一个 ChannelInboundHandler的处理方法也会被调用多次
     * @author xiao tang
     * @date 2022/9/10
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("client --> decode解码");
        // long 8个字节，需要判断有8个字节，才能读取一个long
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
