package com.jyx.test.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

//业务逻辑处理
public class NettySystemHandler extends SimpleChannelInboundHandler<byte[]> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {

        if (!SHUtils.isShengHong(msg)){
            ctx.fireChannelRead(msg);
        }
        String cmd = BytesUtil.getMsgCmd(msg);
        String pileCode = SHUtils.getPileNum(msg);
    }
}
