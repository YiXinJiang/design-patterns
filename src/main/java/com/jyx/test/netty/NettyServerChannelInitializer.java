package com.jyx.test.netty;

import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;

/**
 * @ClassName: NettyServerChannelInitializer
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 11:39
 **/
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        //channel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        //channel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        channel.pipeline().addLast("decoder", new ByteArrayDecoder());
        channel.pipeline().addLast("encoder", new ByteArrayEncoder());

        //超时时间 60秒
        channel.pipeline().addLast("1", new IdleStateHandler(60, 0, 0));
        channel.pipeline().addLast("2", new MyDecoder());
        // channel.pipeline().addLast("6", new NettyDeviceHandler());
        channel.pipeline().addLast("3", new NettyServerHandler()); // 心跳 签到
        channel.pipeline().addLast("4", new NettySystemHandler()); //逻辑
        channel.pipeline().addLast("5", new NettyChargeHandler());

        InetSocketAddress insocket = channel.remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        ChannelId channelId = channel.id(); // 获取连接通道唯一标识通道号
    }

}
