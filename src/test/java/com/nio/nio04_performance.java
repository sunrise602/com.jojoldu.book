package com.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class nio04_performance {

    public static void main(String[] args) throws IOException {

        Path from = Paths.get("src/test/java/com/nio/bg.jpg");
        Path to1 = Paths.get("src/test/java/com/nio/bg_to1.jpg");
        Path to2 = Paths.get("src/test/java/com/nio/bg_to2.jpg");

        long size = Files.size(from);
        long start, end;

        FileChannel fileChannel_from = FileChannel.open(from);

        //논다이렉트 버퍼 생성
        ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);
        FileChannel fileChannel_to1 = FileChannel.open(to1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        start = System.nanoTime();
        for(int i=0; i<100; i++) {
            fileChannel_from.read(nonDirectBuffer);
            nonDirectBuffer.flip();
            fileChannel_to1.write(nonDirectBuffer);
            nonDirectBuffer.clear();
        }
        end = System.nanoTime();
        System.out.println("넌다이렉트:\t" + (end-start) + " ns");

        fileChannel_from.position(0);  //파일채널 읽는 위치를 0번째 위치로..

        //다이렉트 버퍼 생성
        ByteBuffer directBuffer = ByteBuffer.allocateDirect((int)size);
        FileChannel fileChannel_to2 = FileChannel.open(to2, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        start = System.nanoTime();
        for(int i=0; i<100; i++) {
            fileChannel_from.read(directBuffer);
            directBuffer.flip();
            fileChannel_to2.write(directBuffer);
            directBuffer.clear();
        }
        end = System.nanoTime();
        System.out.println("다이렉트:\t" + (end-start) + " ns");

        fileChannel_from.close();
        fileChannel_to1.close();
        fileChannel_to2.close();
    }
}
