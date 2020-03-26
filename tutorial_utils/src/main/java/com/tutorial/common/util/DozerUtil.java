package com.tutorial.common.util;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 对象属性转换
 * @author jimmy
 * @date 2020/3/25 23:21
 */
public class DozerUtil {
    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static<T> List<T> mappperList(Collection sourceList,Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for(Iterator iterator = sourceList.iterator();iterator.hasNext();){
            Object sourceObject = iterator.next();
            Object destinationObject = dozerBeanMapper.map(sourceObject,destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
