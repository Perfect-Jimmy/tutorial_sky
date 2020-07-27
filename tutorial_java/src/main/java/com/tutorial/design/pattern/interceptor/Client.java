package com.tutorial.design.pattern.interceptor;

/**
 * @author jimmy
 * @date 2020/7/26
 */
public class Client {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }
}
