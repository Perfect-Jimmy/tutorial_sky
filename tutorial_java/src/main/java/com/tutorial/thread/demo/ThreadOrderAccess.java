package com.tutorial.thread.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程A，B，C顺序启动
 * A打印A，B打印BB，C打印CC如此顺序打印
 * 交换10轮
 * @author jimmy
 * @date 2020/3/31 22:15
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ResourceShare resourceShare = new ResourceShare();
      /*  new Thread(()->{
            for(int i=1;i<=10;i++){
                resourceShare.printA();
            }
        },"A").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                resourceShare.printB();
            }
        },"B").start();
        new Thread(()->{
            for(int i=1;i<=10;i++){
                resourceShare.printC();
            }
        },"C").start();*/
    }
}

class ResourceShare{
    /**
     * 1 A
     * 2 B
     * 3 C
     */
    private int number = 1;
    /**
     * 一把锁配置3把钥匙
     */
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    /**
     * 在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方法与try代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在finally中无法解锁。
     * 说明一：如果在lock方法与try代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功获取锁。
     * 说明二：如果lock方法在try代码块之内，可能由于其它方法抛出异常，导致在finally代码块中，unlock对未加锁的对象解锁，它会调用AQS的tryRelease方法（取决于具体实现类），抛出IllegalMonitorStateException异常。
     * 说明三：在Lock对象的lock方法实现中可能抛出unchecked异常，产生的后果与说明二相同。 java.concurrent.LockShouldWithTryFinallyRule.rule.desc
     *
     * Positive example：
     *     Lock lock = new XxxLock();
     *     // ...
     *     lock.lock();
     *     try {
     *         doSomething();
     *         doOthers();
     *     } finally {
     *         lock.unlock();
     *     }
     *
     */
   /* public void printA(){
        lock.lock();
        try{
            //判断
            while(number != 1){
                conditionA.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName()+"---AA");
            //通知
            number = 2;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try{
            //判断
            while(number != 2){
                conditionB.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName()+"---BB");
            //通知
            number = 3;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try{
            //判断
            while(number != 3){
                conditionC.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName()+"---CC");
            //通知
            number = 1;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
    }        }*/

}
