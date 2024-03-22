package com.jyx.test.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 管理一个全局map，保存连接进服务端的通道数量
     */
    private static final ConcurrentHashMap<ChannelId, ChannelHandlerContext> CHANNEL_MAP = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ChannelHandlerContext> CLIENT_MAP = new ConcurrentHashMap<>();

    /**
     * @param ctx
     * @author
     * @DESCRIPTION: 有客户端连接服务器会触发此函数
     * @return: void
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        int clientPort = insocket.getPort();
        //获取连接通道唯一标识
        ChannelId channelId = ctx.channel().id();
        if (CLIENT_MAP.containsKey(clientIp)) {
            System.out.println("客户端【" + channelId + "】是连接状态，连接通道数量: " + CLIENT_MAP.size());
        } else {
            //保存连接
            CLIENT_MAP.put(clientIp, ctx);
            System.out.println("客户端【" + channelId + "】连接netty服务器[IP:" + clientIp + "--->PORT:" + clientPort + "]");
        }
    }


    /**
     * 获取客户端连接
     *
     * @param ip ip地址
     * @return
     */
    public static ChannelHandlerContext getClientConnection(String ip) {
        ChannelHandlerContext conn = CLIENT_MAP.get(ip);
        return conn;
    }


    /**
     * @param ctx
     * @DESCRIPTION: 有客户端终止连接服务器会触发此函数
     * @return: void
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        ChannelId channelId = ctx.channel().id();
        //包含此客户端才去删除
        if (CHANNEL_MAP.containsKey(channelId)) {
            //删除连接
            CHANNEL_MAP.remove(channelId);
            System.out.println("客户端【" + channelId + "】退出netty服务器[IP:" + clientIp + "--->PORT:" + insocket.getPort() + "]");
        }
    }


    /**
     * @param ctx
     * @DESCRIPTION: 有客户端发消息会触发此函数
     * @return: void
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        byte[] msg1 = (byte[]) msg;
        if (!SHUtils.isShengHong(msg1)) {
            ctx.fireChannelRead(msg1);
        }
        String cmd = BytesUtil.getMsgCmd(msg1);

        String pileCode = SHUtils.getPileNum(msg1);

        ClientManager.addClientConnection(ctx, pileCode);

        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();

        String clientIp = insocket.getAddress().getHostAddress();

        CLIENT_MAP.put(clientIp, ctx);

        if (cmd.equalsIgnoreCase("6a00")) { //充电桩签到 cmd=106
            System.out.println("充电桩签到 cmd=106");
            CLIENT_MAP.put(clientIp, ctx);
            ClientManager.addClientConnection(ctx, pileCode);
        } else if (cmd.equalsIgnoreCase("6600")) { //充电桩上传心跳包 cmd=102
            System.out.println("充电桩上传心跳包 cmd=102");
            CLIENT_MAP.put(clientIp, ctx);
            ClientManager.addClientConnection(ctx, pileCode);
            byte[] hbSlave = new byte[]{12, 11};
            ctx.writeAndFlush(hbSlave);
            //响应客户端
            this.channelWrite(ctx.channel().id(), hbSlave);
        } else {
            ctx.fireChannelRead(msg);
        }
    }


    /**
     * @param msg       需要发送的消息内容
     * @param channelId 连接通道唯一id
     * @author xiongchuan on 2019/4/28 16:10
     * @DESCRIPTION: 服务端给客户端发送消息
     * @return: void
     */
    public void channelWrite(ChannelId channelId, Object msg) throws Exception {
        ChannelHandlerContext ctx = CHANNEL_MAP.get(channelId);
        if (ctx == null) {
            return;
        }
        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    /**
     * @param ctx
     * @author xiongchuan on 2019/4/28 16:10
     * @DESCRIPTION: 发生异常会触发此函数
     * @return: void
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
