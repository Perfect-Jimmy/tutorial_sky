package com.tutorial.design.pattern.interceptor;

/**
 * @author jimmy
 * @date 2020/7/26
 */
public class DebugFilter implements Filter{
    @Override
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
