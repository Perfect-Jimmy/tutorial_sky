package com.tutorial.multithread.core;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个售票员卖30张票
 * 高内聚低耦合，线程  资源类
 * @author jimmy
 * @date 2020/3/26 00:26
 */
public class SaleTicketsDemo01 {

    public static void main(String[] args) {
        final Ticket ticket = new Ticket();
        new Thread(()->{for(int i=1;i<40;i++) {
            ticket.sale();
          }
        },"A").start();
        new Thread(()->{for(int i=1;i<40;i++) {
            ticket.sale();
        }
        },"B").start();
        new Thread(()->{for(int i=1;i<40;i++) {
            ticket.sale();
        }
        },"C").start();
        //实现不优雅
       /* new Thread(new Runnable() {
            public void run() {
                for(int i=1;i<40;i++){
                    ticket.sale();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            public void run() {
                for(int i=1;i<40;i++){
                    ticket.sale();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            public void run() {
                for(int i=1;i<40;i++){
                    ticket.sale();
                }
            }
        },"C").start();*/
    }
}

/**
 * 资源类
 */
class Ticket{
    private int number = 30;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    public void sale(){
        //注意lock在try外面
        lock.lock();
        try {
            if(number > 0){
                //Thread.sleep(1000L);
                number--;
                System.out.println(Thread.currentThread().getName()+"卖出第"+(++count)+"张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
