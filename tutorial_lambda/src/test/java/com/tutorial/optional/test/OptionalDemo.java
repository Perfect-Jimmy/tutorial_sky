package com.tutorial.optional.test;






import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author jimmy
 * @date 2020/5/9
 */
public class OptionalDemo {
    //-------------------------------------------------------------------------
    // Optional(T value)  私有构造函数
    // empty()       返回内部维护的一个EMPTY对象
    // of(T value)   value为空时依旧会抛出NPE异常,不为空时可以正常构造Optional对象
    // ofNullable(T value) 如果value为空时，返回EMPTY对象
    @Test
    public void test1_1(){
        String str = "111";
        Optional<String> str1 = Optional.of(str);
        System.out.println(str1.get());
    }

    @Test
    public void test1_2(){
        String str = null;
        Optional<String> str1 = Optional.ofNullable(str);
        System.out.println(str1);//返回Optional.empty
    }

    //-------------都是在构造函数传入的value值为null时，进行调用的------------------------
    // orElse(T other)
    // orElseGet(Supplier<? extends T> other)
    // orElseThrow(Supplier<? extends X> exceptionSupplier) 如果value为空则直接抛出异常

    @Test
    public void test2() throws Exception {
        String str = "123";
        //如果str为空则执行else;如果不为空,else也会执行，但是返回值是str
        String str1 = Optional.ofNullable(str).orElse(new OptionalDemo().hello());
        System.out.println("str1="+str1);
        //如果str为空则执行elseGet;不为空elseGet不会执行
        String str2 = Optional.ofNullable(str).orElseGet(()->new OptionalDemo().hello());
        System.out.println("str2="+str2);
        Optional.ofNullable(str).orElseThrow(()->new Exception("value为空"));
    }

    public String hello(){
        System.out.println("hello");
        return "hello";
    }

    //---------------------------------------------------------------------------------
    // map(Function<? super T, ? extends U> mapper)
    // flatMap(Function<? super T, Optional<U>> mapper)



    //------------------判断value是否为空------------------------------------------------
    // isPresent()
    // ifPresent(Consumer<? super T> consumer)   不为空时可以做一些操作



    //-----------------------------------------------------------------------------------
    // filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty
    @Test
    public void test5(){
        String str = "123";
        Optional<String> str1 = Optional.ofNullable(str).filter(s->s.equals("123"));
        System.out.println(str1);
    }


    @Test
    public void test6(){
        Map<String,Object> map = new HashMap<>();
        System.out.println(map+"-====");
        Object effectDate = map.get("effect_date");
        Object transferType = map.get("transfer_type");
        //如果存在值则使用ifPresent里面的数据代替
        Optional.ofNullable(effectDate).ifPresent(s -> map.put("effect_date", LocalDate.now().plusDays(1)));
        Optional.ofNullable(transferType).ifPresent(s -> map.put("transfer_type",4));
        System.out.println(map);
    }
}
