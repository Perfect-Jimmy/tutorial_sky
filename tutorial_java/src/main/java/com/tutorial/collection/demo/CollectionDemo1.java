package com.tutorial.collection.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jimmy
 * @description
 * @date 2020/4/10 17:16
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        System.out.println(list.toArray(new String[0]));
        System.out.println(list.toArray());
    }
}
