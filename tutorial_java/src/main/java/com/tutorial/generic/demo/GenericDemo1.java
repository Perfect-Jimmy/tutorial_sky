package com.tutorial.generic.demo;

import java.util.ArrayList;

/**
 * 类型擦除
 * @author jimmy
 * @description
 * @date 2020/4/9 23:11
 */
public class GenericDemo1 {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();
        ArrayList<String> strArray = new ArrayList<>();
        System.out.println(intArray.getClass());
        System.out.println(strArray.getClass());
        System.out.println(intArray.getClass() == strArray.getClass());
    }
}
/*
class java.util.ArrayList
class java.util.ArrayList
true
说明Integer和String类型被擦除掉了
*/
