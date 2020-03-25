package com.tutorial;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
public class Test1Main {
    public static void main(String[] args) {
        Test1<String> t1 = new Test1<String>() {
            @Override
            public String call() {
                return "hello";
            }
        };

        System.out.println(t1.call());
    }
}
