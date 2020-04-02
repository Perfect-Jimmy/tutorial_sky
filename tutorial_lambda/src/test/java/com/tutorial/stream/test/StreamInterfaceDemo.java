package com.tutorial.stream.test;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 函数式接口
 * @author jimmy
 * @date 2020/4/2 11:28
 */
public class StreamInterfaceDemo {
    /**
     * Consumer 消费者接口，就是用来消费数据的
     * Consumer 接口中有accept 抽象方法，accept接受一个变量，也就是说你在使用这个函数式接口的时候，给你提供了数据，你只要接收使用就可以了；
     * andThen 是一个默认方法，接受一个Consumer 类型，当你对一个数据使用一次还不够爽的时候，你还能再使用一次，当然你其实可以爽无数次，只要一直使用andThan方法
     */
    @Test
    public void consumerDemo(){

    }


    /**
     * Function 提供一种转换功能
     * unction 接口 最主要的就是apply 函数，apply 接受T类型数据并返回R类型数据，就是将T类型的数据转换成R类型的数据，
     * 它还提供了compose、andThen、identity 三个默认方法，compose 接受一个Function，andThen也同样接受一个Function，
     * 这里的andThen 与Consumer 的andThen 类似，在apply之后在apply一遍，compose 则与之相反，在apply之前先apply（这两个apply具体处理内容一般是不同的），
     * identity 起到了类似海关的作用，外国人想要运货进来，总得交点税吧，然后货物才能安全进入中国市场，当然了想不想收税还是你说了算的:
     */
    @Test
    public void functionDemo(){
        Function<Integer,Integer> square = integer -> integer*integer;
        //平方
        Stream.of(1,2,3,4).map(square).forEach(System.out::println);
        System.out.println("-------------------");
        //四次方
        Stream.of(1,2,3,4).map(square.andThen(square)).forEach(System.out::println);
        System.out.println("-------------------");
        //减1再平方
        Stream.of(1,2,3,4).map(square.compose(e->e-1)).forEach(System.out::println);
    }

    /**
     * 求和
     * Operator
     */
    @Test
    public void intBinaryOperatorDemo(){
        IntBinaryOperator intBinaryOperator = (e1,e2) -> (e1+e2);
        IntStream.of(1,2,3).reduce(intBinaryOperator).ifPresent(System.out::println);
    }

    /**
     * 找出最大值
     */
    @Test
    public void binaryOperatorDemo(){
        Stream.of(2,4,5,6,7,1)
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(Integer::intValue))).ifPresent(System.out::println);

    }
    /**
     * Predicate的test 接收T类型的数据，返回 boolean 类型，即对数据进行某种规则的评判，如果符合则返回true，否则返回false；
     * Predicate接口还提供了 and、negate、or，与 取反 或等，isEqual 判断两个参数是否相等等默认函数
     *
     */
    @Test
    public void predicateDemo(){

    }

    /**
     * Supplier
     * 生产 提供数据  get方法返回一个T类数据，可以提供重复的数据，或者随机种子都可以
     */
    @Test
    public void supplierDemo(){
        Stream.generate(()->2).limit(10).forEach(System.out::println);
    }
}
