package com.tutorial.design.pattern.interceptor;

/**
 * @author jimmy
 * @date 2020/7/26
 */
public class Target {
    public void execute(String request){
        System.out.println("Executing target request: " + request);
    }
}
