package com.jyx.test.netty;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @ClassName: TcpClient
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-29 13:40
 **/
public class TcpClient {


    public void testLongConn() throws Exception {
        String host = "192.168.1.61";
        int port = 8899;
        final Socket socket = new Socket();
        socket.connect(new InetSocketAddress(host, port));
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);

        String content = "aaf5b500109a";
        byteBuffer.put(hexToByteArray(content));
        socket.getOutputStream().write(byteBuffer.array());
        socket.close();
    }

    // 因为Junit不支持用户输入,所以用main的方式来执行用例
    public static void main(String[] args) throws Exception {
        new TcpClient().testLongConn();
    }

    /**
     * hex字符串转byte数组
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte数组结果
     */
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

    /**
     * Hex字符串转byte
     *
     * @param inHex 待转换的Hex字符串
     * @return 转换后的byte
     */
    public static byte hexToByte(String inHex) {
        return (byte) Integer.parseInt(inHex, 16);
    }

}
