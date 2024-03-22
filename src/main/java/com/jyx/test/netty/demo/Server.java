package com.jyx.test.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName: Server
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 15:18
 **/
public class Server {

    /**
     * @Description 测试handler链的服务器
     * @author xiao tang
     * @version 1.0.0
     * @createTime 2022年09月10日
     */
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new NettyServerInitializer()); // 自定义一个初始化类
            // 自动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(8089).sync();
            System.out.println("服务器启动成功");
            // 监听关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
