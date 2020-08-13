package com.tutorial.design.pattern.businessdelegate;

/**
 * 3. 业务查询接口
 * @author jimmy
 * @date 2020/8/2
 */
public class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType){
        if(serviceType.equalsIgnoreCase("EJB")){
            return new EJBService();
        }else {
            return new JMSService();
        }
    }
}
