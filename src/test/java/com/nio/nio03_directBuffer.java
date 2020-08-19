package com.nio;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;

public class nio03_directBuffer {

    public static void main(String[] args) {


        System.nanoTime();
        long start = System.currentTimeMillis();
        //다이렉트 버퍼 생성 = 운영체제 메모리에 생성. 생성이 느림
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(999*1024*1024); // 200MB
        System.out.println("다이렉트 버퍼가 생성되었습니다.");
        long end = System.currentTimeMillis();
        System.out.println(String.format("%d msec", end - start));

        long start2 = System.currentTimeMillis();
        //논다이렉트 버퍼 생성 = JVM 메모리에 생성 (임시 다이렉트버퍼에 복사). 생성 빠름
        ByteBuffer nonDirectBuffer = ByteBuffer.allocate(999*1024*1024); // 200MB
        System.out.println("논다이렉트 버퍼가 생성되었습니다.");
        long end2 = System.currentTimeMillis();
        System.out.println(String.format("%d msec", end2 - start2));
    }
}
