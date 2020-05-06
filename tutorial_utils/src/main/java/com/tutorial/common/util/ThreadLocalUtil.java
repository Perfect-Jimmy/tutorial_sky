package com.tutorial.common.util;

/**
 * @author jimmy
 * @date 2020/5/6
 */
public class ThreadLocalUtil {
    private final static ThreadLocal<String> requestHolder = new ThreadLocal<>();

    public static void addKey(String id) {
        requestHolder.set(id);
    }

    public static String getKey() {
        return requestHolder.get();
    }

    public static void removeKey() {
        requestHolder.remove();
    }
}
