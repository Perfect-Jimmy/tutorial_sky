package com.tutorial.design.pattern.servicelocator;

/**
 * 接口的具体实现之一
 * @author jimmy
 * @date 2020/8/2
 */
public class Service1 implements Service {
    @Override
    public void execute(){
        System.out.println("Executing Service1");
    }

    @Override
    public String getName() {
        return "Service1";
    }
}
