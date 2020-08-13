package com.tutorial.design.pattern.businessdelegate;

/**
 * 2. 业务接口的具体实现之一
 * @author jimmy
 * @date 2020/8/2
 */
public class EJBService implements BusinessService{
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
