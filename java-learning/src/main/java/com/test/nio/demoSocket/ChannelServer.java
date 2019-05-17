package com.test.nio.demoSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by iQiwen on 2019/3/29.
 */
public class ChannelServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8089));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            System.out.println("ChannelServer 启动");
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                socketChannel.read(byteBuffer);
                System.out.println("收到=" + new String(byteBuffer.array()));
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
            }
        }
    }
}
