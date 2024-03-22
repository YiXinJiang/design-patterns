package com.jyx.test.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @ClassName: MyDecoder
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 11:40
 **/
public class MyDecoder extends MessageToMessageDecoder<byte[]> {

    private static final Logger log = LoggerFactory.getLogger(MyDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
        try {
            if (SHUtils.isShengHong(msg)) {
                // 盛宏桩
                unpackSH(msg, out);
            } else {
                log.info(" unkown proctrol 未知协议类型");
            }
        } catch (Exception e) {
            log.error(" decode Exception : " + e);
        }
    }

    /**
     * 盛宏拆包
     */
    private void unpackSH(byte[] msg, List<Object> out) {
        // 一个整包的长度
        int len = BytesUtil.toInt2(msg, 2);
        if (msg.length <= len) { // 一个整包
            out.add(msg);
        } else {
            // 1.取出一个包的数据
            byte[] array = new byte[len];
            System.arraycopy(msg, 0, array, 0, len);
            out.add(array);

            // 2. 多余的数据继续分包
            int other = msg.length - len;
            array = new byte[other];
            System.arraycopy(msg, len, array, 0, array.length);
            unpackSH(array, out);
        }
    }

    /**
     * 硕维拆包
     */
    private void unpacking(byte[] msg, List<Object> out) {
        if (msg[0] == 0x18) {
            // 一个整包的长度
            int len = BytesUtil.toInt2(msg, 1) + 3;
            if (msg.length <= len) { // 一个整包
                out.add(msg);
            } else {
                // 1.
                byte[] array = new byte[len];
                System.arraycopy(msg, 0, array, 0, len);
                out.add(array);

                // 2. 多余的数据继续分包
                int other = msg.length - len;
                array = new byte[other];
                System.arraycopy(msg, len, array, 0, array.length);
                unpacking(array, out);

            }

        } else {
            out.add(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = address.toString();
        log.info("channelActive -->  RamoteAddress : " + ip + " connected ");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error(" exceptionCaught : " + cause.toString() + " ctx = " + ctx.channel().toString());
        ctx.close();
    }

}
