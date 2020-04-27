package com.tutorial.stream.test;


import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author jimmy
 * @date 2020/4/2 09:18
 */
public class StreamDemo {
    @Test
    public void test(){

    }

    /**
     * 流的创建
     */
    @Test
    public void buildStream(){
        //从数组创建
        int[] array = {1,2,3};
        IntStream intStream = Arrays.stream(array);
        System.out.println(intStream);
        //从集合创建
        List list = Arrays.asList(1,2,3);
        Stream listStream = list.stream();
        //创建1-10的流
        IntStream intRangeStream = IntStream.rangeClosed(1,10);
        intRangeStream.forEach(System.out::println);
        //直接创建
        Stream stream = Stream.of("a","b");
        stream.forEach(s->{
            System.out.println(s);
        });
        //这里会一直乘以2，输出10个元素：1、2、4、8、16、32、64、128、256、512
        IntStream.iterate(1, (e) -> e * 2).limit(10).forEach(System.out::println);
        //
        int sum = IntStream.builder().add(1).add(2).add(3).build().sum();
        Assert.assertEquals(61, sum);
    }

    /**
     *  将元素中的所有偶数累加求和
     */
    @Test
    public void streamOperation1(){
        int[] nums = {2, 3, 4, 5, 6};
        Integer result = Arrays.stream(nums)
                .map(i -> i % 2 == 0 ? i : 0)
                .reduce(0, Integer::sum);
        System.out.println(result);
    }

    /**
     * flatMap操作嵌套的list
     */
    @Test
    public void streamOperation2(){
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6));
        list.stream().flatMap(l->l.stream())
                .map(i->i*2)
                .forEach(j-> System.out.println(j));
    }


    /**
     * 假设有N条营业数据，前5条是无关的测试数据，中间10条是要参加考核的，参与考核的需要知道其中超过50w（包括50）的数据的交易额平均值，其他不参与考核的忽略
     */
    @Test
    public void streamOperation3(){
        Stream<Integer> trans = Stream.of(11, 9, 2, 13, 1, 2, 99, 54, 23, 66, 70, 23, 46, 50, 100, 10, 24, 18, 19, 2);
        IntSummaryStatistics all = trans
                //跳过前5个
                .skip(5)
                //取中间10个
                .limit(10)
                //过滤小于50的数据
                .filter(i->i>=50)
                //转换成数字。如果是IntStream 则不需要转换
                .mapToInt(i->i)
                //将流的统计结果放入包装对象中
                .summaryStatistics();
        System.out.println(all.getAverage());
        System.out.println(all.getCount());
    }

    /**
     * 获取第一个元素 返回Optional
     */
    @Test
    public void streamOperation4(){
        Stream<Integer> trans = Stream.of(11, 9, 2, 13, 1, 2, 99, 54, 23, 66, 70, 23, 46, 50, 100, 10, 24, 18, 19, 2);
        Optional<Integer> optional = trans.findFirst();
        optional.ifPresent((i)-> System.out.println(i));
    }

    /**
     * noneMatch 数据流中没有一个元素与条件匹配的
     */
    @Test
    public void streamOperation5(){
        Stream<Integer> trans = Stream.of(11, 9, 2, 13, 1, 2, 99, 54, 23, 66, 70, 23, 46, 50, 100, 10, 24, 18, 19, 2);
        boolean flag = trans.noneMatch(i->(i==23));
        System.out.println(flag);
    }
    /**
     * collectors操作
     */
    @Test
    public void streamOperation10(){
        Stream<Integer> trans = Stream.of(11, 9, 2, 13, 1, 2, 99, 54, 23, 66, 70, 23, 46, 50, 100, 10, 24, 18, 19, 2);
        Set set = trans.collect(Collectors.toSet());
        set.forEach(System.out::println);
    }


    @Test
    public void testMapObject() {
        // 这里转成string对象
        IntStream.of(1, 2, 3).mapToObj(String::valueOf).map(Object::getClass).forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        // 这里根据上游的元素扩展出了更多的元素
        IntStream.of(1, 2, 3).flatMap(e -> IntStream.rangeClosed(0, e)).forEach(System.out::println);
    }

    /**
     * peek操作
     */
    @Test
    public void testPeek() {
        IntStream.of(1, 2, 3, 4, 5)
                .filter(e -> e >= 3)
                .peek(value -> System.out.printf("filter element: %d\n", value))
                .mapToObj(String::valueOf)
                .forEach(System.out::println);
    }

    @Test
    public void testTrace(){
        Stream.of("xxx","12345")
                .map(String::length).collect(Collectors.toSet());
    }

    @Test
    public void testFilter(){
        List<String> list = Lists.newArrayList("aa","bb","cc");
        System.out.println(list);
        List<String> list2 = list.stream().filter(s->s.equals("bb")).collect(Collectors.toList());
        System.out.println(list2);
    }

}
