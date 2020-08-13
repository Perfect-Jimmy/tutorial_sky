package com.tutorial.design.pattern.businessdelegate;

/**
 * 4. 创建业务代表
 * 为什么要再声明一个serviceType？？
 * @author jimmy
 * @date 2020/8/2
 */
public class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public void doTask(){
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
