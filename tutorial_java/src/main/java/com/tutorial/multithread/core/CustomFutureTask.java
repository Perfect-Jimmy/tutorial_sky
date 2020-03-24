package com.tutorial.multithread.core;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义futureTask,模拟FutureTask
 * 注意点:
 * 1.Thread里面只能执行runnable,不能执行callable
 * 2.需要保证get()之前callable的call方法已经对result赋值
 * @author jimmy
 * @date 2020/3/24 22:08
 */
public class CustomFutureTask<T> implements Runnable{
    Callable<T> callable;
    /**
     * 定义返回结果
     */
    T result;

    /**
     * 为实现2，定义一个状态变量,定义一个容器装入线程
     */
    volatile  String state = "new";
    LinkedBlockingQueue<Thread> queue = new LinkedBlockingQueue<Thread>();


    public CustomFutureTask(Callable<T> callable) {
        this.callable = callable;
    }

    public T get(){
        if("END".equals(state)){
            return result;
        }
        //阻塞
        while (!"END".equals(state)){
            System.out.println("阻塞。。。。");
            queue.add(Thread.currentThread());
            LockSupport.park();
        }
        return result;
    }

    public void run() {
        try {
            result = callable.call();;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            state = "END";
        }
        Thread thread = queue.poll();
        while (thread != null){
            LockSupport.unpark(thread);
            thread = queue.poll();
        }
    }
}
