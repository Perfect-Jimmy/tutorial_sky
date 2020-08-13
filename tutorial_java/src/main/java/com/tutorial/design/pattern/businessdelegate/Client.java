package com.tutorial.design.pattern.businessdelegate;

/**
 * 5. 创建客户端
 * @author jimmy
 * @date 2020/8/2
 */
public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService){
        this.businessService  = businessService;
    }

    public void doTask(){
        businessService.doTask();
    }
}
