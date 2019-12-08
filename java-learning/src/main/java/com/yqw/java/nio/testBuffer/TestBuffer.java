package com.yqw.java.nio.testBuffer;

import java.nio.ByteBuffer;

public class TestBuffer {
    public static void main(String[] args) throws Exception {
        ByteBuffer bb = ByteBuffer.allocate(48);
        String str = "ceshiwenjianneirong...";
        byte[] tmp = str.getBytes();
        System.out.println((char)bb.get());
        bb.clear();
        System.out.println(bb.toString());
        bb.put(tmp);
        System.out.println(bb.toString());
        // 从写模式切换到读模式
        bb.flip();
        System.out.println(bb.toString());
        System.out.println((char) bb.get(0) + " , " + (char) bb.get(3));
        System.out.println(bb.toString());
        System.out.println(bb.flip().toString());
    }
}