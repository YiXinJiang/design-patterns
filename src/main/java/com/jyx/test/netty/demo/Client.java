package com.jyx.test.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: Client
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:20
 **/
public class Client {

    /**
     * @Description netty客户端
     * @author xiao tang
     * @version 1.0.0
     * @createTime 2022年09月10日
     */
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new NettyClientInitializer());  // 自定义一个初始化类
            // 连接服务器
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8089).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

}
