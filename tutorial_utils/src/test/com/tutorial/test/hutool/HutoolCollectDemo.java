package com.tutorial.test.hutool;

import cn.hutool.core.collection.CollUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 集合类
 * @author jimmy
 * @date 2020/6/2
 */
public class HutoolCollectDemo {

    @Test
    public void test1(){
        List<Integer> list1 = Lists.list(1,2,3);
        List<Integer> list2 = Lists.list(1,3,4,5);
        List<Integer> same = (List) CollUtil.intersection(list1, list2);
        System.out.println(same);
    }
}
