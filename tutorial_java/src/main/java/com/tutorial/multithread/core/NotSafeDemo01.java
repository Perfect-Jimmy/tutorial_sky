package com.tutorial.multithread.core;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程不安全
 * 1.故障现象
 * java.util.ConcurrentModificationException
 * 2.导致原因
 * 多线程争抢资源没加锁
 * 3.解决方案
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
        //NotSafeDemo01.listNotSafe();
        //NotSafeDemo01.setNotSafe();
        mapNotSafe();
    }

    /**
     * map线程不安全
     * 底层是node类型的数组，链表，红黑树
     * 解决方案:ConcurrentHashMap()
     */
    public static void mapNotSafe(){
        Map<String,String> map = new HashMap<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,5),"");
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
    /**
     * set线程不安全
     * hashSet底层数据结构hashMap
     * 解决方案:CopyOnWriteArraySet()
     */
    public static void setNotSafe(){
        Set<String> set = new HashSet<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
    /**
     * list线程不安全
     * list底层结构是数组,每次扩容当前list长度的一半
     */
    public static void listNotSafe(){
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
