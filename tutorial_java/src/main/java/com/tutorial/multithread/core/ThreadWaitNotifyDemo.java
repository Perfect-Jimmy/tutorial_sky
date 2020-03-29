package com.tutorial.multithread.core;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目:两个线程操作一个初始值为零的变量,其中一个线程对变量加1，另一个线程减1，实现交替，10轮只有变量值仍为零
 * v1.0 一个生产者 一个消费者
 * v2.0 两个生产者 连个消费者
 * 1. 高内聚低耦合前提下，线程操作资源类
 * 2. 判断  干活  通知
 * 3. 多线程交互中，必须要防止多线程的虚假唤醒，也即资源类中的判断不能用if,要用while
 * @author jimmy
 * @date 2020/3/28 23:46
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        ThreadWaitNotifyDemo threadWaitNotifyDemo = new ThreadWaitNotifyDemo();
        threadWaitNotifyDemo.newVersion();
    }

    public void newVersion(){
        ResourceLock resourceLock = new ResourceLock();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                resourceLock.increment();
            }
        },"A").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                resourceLock.decrement();
            }
        },"B").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                resourceLock.increment();
            }
        },"C").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                resourceLock.decrement();
            }
        },"D").start();
    }

    public void oldVersion(){
        ResourceCondition resourceCondition = new ResourceCondition();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    resourceCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    resourceCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    resourceCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                try {
                    resourceCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

/**
 * 资源类 lock 版
 */
class ResourceLock{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try{
            while (number !=0 ){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"--"+number);
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try{
            while (number ==0 ){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"--"+number);
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}

/**
 * 资源类
 */
class ResourceCondition{
    private int number = 0;

    /**
     * 加
     * @throws InterruptedException
     */
    public synchronized void increment() throws InterruptedException {
        //判断
        if(number != 0){
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"-加-"+number);
        //通知
        this.notifyAll();
    }

    /**
     * 减
     * @throws InterruptedException
     */
    public synchronized void decrement() throws InterruptedException {
        if(number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"-减-"+number);
        this.notifyAll();
    }
}


