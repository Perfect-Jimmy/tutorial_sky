package com.tutorial.utils;

import java.util.function.Predicate;

/**
 * 业务校验工具类
 * @author jimmy
 * @date 2020/4/17
 */
public class BusinessCheckUtil<T> {
    public static<T> boolean check(T value,Predicate<T> predicate){
        return predicate.test(value);
    }
}
