package com.tutorial.multithread.core;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程不安全
 * 1.故障现象
 * java.util.ConcurrentModificationException
 * 2.导致原因
 *
 * 3.解决办法
 * 3.1  List<String> list = new Vector<>();
 * 3.2  List<String> list = Collections.synchronizedList(new ArrayList<>());
 * 3.2  List<String> list = new CopyOnWriteArrayList<>();
 * 4.优化建议
 *
 *
 * @author jimmy
 * @date 2020/3/27 00:50
 */
public class NotSafeDemo01 {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

       // List<String> list = Collections.synchronizedList(list1);
        for(int i=1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
                },String.valueOf(i)).start();
        }
    }
}
