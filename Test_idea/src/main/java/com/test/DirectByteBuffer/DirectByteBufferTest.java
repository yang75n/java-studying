package com.test.directByteBuffer;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class DirectByteBufferTest {
    public static void main(String[] args) throws InterruptedException {
        //分配512MB直接缓存
        ByteBuffer bb = ByteBuffer.allocateDirect(1024 * 1024 * 512);

        TimeUnit.SECONDS.sleep(10);



        //清除直接缓存
                ((DirectBuffer) bb).cleaner().clean();

        TimeUnit.SECONDS.sleep(10);

        System.out.println("ok");
    }
}