package com.tutorial.base;

import com.tutorial.pojo.User;
import org.springframework.util.ReflectionUtils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author jimmy
 * @date 2020/4/1 14:07
 */
public class IntrospectorDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("jimmy");
        PropertyDescriptor[] propertyDescriptors;
        try {
            propertyDescriptors = Introspector.getBeanInfo(user.getClass()).getPropertyDescriptors();
            for(PropertyDescriptor pd:propertyDescriptors){
                System.out.println(pd.getName());
                System.out.println(pd.getReadMethod());
                if(!"class".equals(pd.getName())){
                    Object value = ReflectionUtils.invokeMethod(pd.getReadMethod(), user);
                    System.out.println("--=="+value);
                }
            }
           // Object value = ReflectionUtils.invokeMethod(pd.getReadMethod(), object);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
/*
address
public com.tutorial.pojo.Address com.tutorial.pojo.User.getAddress()
        --==null
class
public final native java.lang.Class java.lang.Object.getClass()
        id
public java.lang.Integer com.tutorial.pojo.User.getId()
        --==1
        name
public java.lang.String com.tutorial.pojo.User.getName()
 --==jimmy
*/
