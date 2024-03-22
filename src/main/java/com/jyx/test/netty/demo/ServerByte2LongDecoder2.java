package com.jyx.test.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @ClassName: MyByte2LongDecoder2
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:22
 **/
public class ServerByte2LongDecoder2 extends ReplayingDecoder {

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
        System.out.println("server --> decode解码");
        // ReplayingDecoder，无需判断字节流是否足够读取，内部会进行处理判断
//        if (in.readableBytes() >= 8) { // 无需判断
        out.add(in.readLong());
//        }
    }
}
