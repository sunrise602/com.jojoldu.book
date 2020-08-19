package com.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class nio_directBufferCapacity {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100).order(ByteOrder.nativeOrder());
        System.out.println(byteBuffer.capacity() + "바이트");

        CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();
        System.out.println(charBuffer.capacity() + "문자");

        IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
        System.out.println(intBuffer.capacity() + "정수");

        System.out.println(ByteOrder.nativeOrder()); //LITTLE_ENDIAN
    }


}
