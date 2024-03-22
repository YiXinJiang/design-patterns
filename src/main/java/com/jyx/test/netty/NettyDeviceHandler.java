package com.jyx.test.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.ByteBuffer;

/**
 * @ClassName: NettyDeviceHandler
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 14:46
 **/
public class NettyDeviceHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("---------NettyDeviceHandler-------------");
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        String content = "aaf5b500109a";
        byteBuffer.put(hexToByteArray(content));
        ctx.writeAndFlush(byteBuffer.array());
    }

    public static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            //奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            //偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

}
