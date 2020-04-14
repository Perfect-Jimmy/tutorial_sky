package com.tutorial.common.demo;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * https://www.jianshu.com/p/4b81fc1540f3
 * @author jimmy
 * @description
 * @date 2020/4/14 11:59
 */
public class CommonDemo {
    /**
     * 流的拼接
     */
    @Test
    public void demo1(){
        Stream stream1 = Stream.iterate(10, n -> n + 2).limit(3);
        Stream stream2 = Stream.generate(()-> UUID.randomUUID().toString()).limit(3);
        Stream.concat(stream1,stream2).forEach(System.out::println);
    }

    /**
     *  时间戳
     * @throws InterruptedException
     */
    @Test
    public void demo2() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(1000*2);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }
}
