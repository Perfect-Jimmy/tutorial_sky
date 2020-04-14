package com.tutorial.stream.demo;

import org.junit.jupiter.api.Test;

/**
 * @author jimmy
 * @description
 * @date 2020/4/14 14:09
 */
public class StreamDemo {
    /**
     *  配置并行流线程池
     *  并行流内部使用了默认的ForkJoinPool,它默认的线程数量就是你的处理器数量
     *  这个值是由Runtime.getRuntime().availableProcessors()得到的
     *  改变线程池大小:
     *  System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12")
     */
    @Test
    public void demo1(){
      //  System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
