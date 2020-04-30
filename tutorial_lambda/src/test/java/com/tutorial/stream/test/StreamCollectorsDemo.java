package com.tutorial.stream.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jimmy
 * @date 2020/4/2 11:21
 */
public class StreamCollectorsDemo {

  /*  contactInfoMap = fields3.parallelStream().collect(HashMap::new, (map, o) -> {
        map.put(o.getFieldCode(), categoryId);
    }, HashMap::putAll);*/
    @Test
    public void demo1(){
        Stream.of(1,2,3).collect(Collectors.toSet());
        Stream.of(1,2,3).collect(Collectors.toCollection(ArrayList::new));
    }


    @Test
    public void demo2(){
        Student student1 = new Student(1,"jimmy");
        Student student2 = new Student(2,"tommy");
        Student student3 = new Student(3,"killy");
        //function.identity() 获取这个对象本身，那么结果就是Map<String,Student> 即 id->student
        //串行收集
        Stream.of(student1,student2,student3).collect(Collectors.toMap(Student::getId, Function.identity()));
        //并行收集
        Map map = Stream.of(student1,student2,student3).parallel().collect(Collectors.toMap(Student::getId, Function.identity()));
        Stream.of(map).forEach((q)->{
            System.out.println(q);
        });
        System.out.println(map);

        //key相同的比较name大小来取值
        //Map<String,Student>
        Stream.of(student1, student2, student3)
                .collect(Collectors
                        .toMap(Student::getId,
                                Function.identity(),
                                BinaryOperator
                                        .maxBy(Comparator.comparing(Student::getName))));


        //可能上面比较复杂，这编写一个命令式
        //Map<String,Student>
        Stream.of(student1, student2, student3)
                .collect(Collectors
                        .toMap(Student::getId,
                                Function.identity(),
                                (s1, s2) -> {
                                    //这里使用compareTo 方法 s1>s2 会返回1,s1==s2 返回0 ，否则返回-1
                                    if (((Student) s1).getName().compareTo(((Student) s2).getName()) < -1) {
                                        return s2;
                                    } else {
                                        return s1;
                                    }
                                }));

        //
        //自定义LinkedHashMap
        //Map<String,Student>
        Stream.of(student1, student2, student3)
                .collect(Collectors
                        .toMap(Student::getId,
                                Function.identity(),
                                BinaryOperator
                                        .maxBy(Comparator.comparing(Student::getName)),
                                LinkedHashMap::new));
    }

    /**
     * 聚合规约 Collectors.joining()，拼接，有三个重载方法，底层实现是StringBuilder，通过append方法拼接到一起，并且可以自定义分隔符
     */
    @Test
    public void demo3(){
        Student student1 = new Student(1,"jimmy");
        Student student2 = new Student(2,"tommy");
        Student student3 = new Student(3,"killy");
        //自定义收集的字段
        //List<String>
        Stream.of(student1,student2,student3)
                .collect(Collectors.mapping(Student::getName,Collectors.toList()));

        //listIterator 收集后转成了list Iterator
        Stream.of(student1,student2,student3)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::listIterator));

        //使用分隔符：201900012019000220190003
      /*  Stream.of(student1, student2, student3)
                .map(Student::getId)
                .collect(Collectors.joining());*/

        //使用^_^ 作为分隔符
        //20190001^_^20190002^_^20190003
       /* Stream.of(student1, student2, student3)
                .map(Student::getId)
                .collect(Collectors.joining("^_^"));*/

       //使用^_^ 作为分隔符
        //[]作为前后缀
        //[20190001^_^20190002^_^20190003]
      /*  Stream.of(studentA, studentB, studentC)
                .map(Student::getId)
                .collect(Collectors.joining("^_^", "[", "]"));*/
    }

    @Test
    public void demo4(){
        Stream.of(1, 0, -10, 9, 8, 100, 200, -80)
                .collect(Collectors.maxBy(Integer::compareTo)).ifPresent(System.out::println);
    }

    /**
     * 求学生名字长度
     */
    @Test
    public void demo5(){
        Student student1 = new Student(1,"jimmy");
        Student student2 = new Student(2,"tommy");
        Student student3 = new Student(3,"killy");

        //Optional[6]
        Stream.of(student1, student2, student3)
                .map(student -> student.getName().length())
                .collect(Collectors.reducing(Integer::sum));

        //6
        //或者这样，指定初始值，这样可以防止没有元素的情况下正常执行
        Stream.of(student1, student2, student3)
                .map(student -> student.getName().length())
                .collect(Collectors.reducing(0, (i1, i2) -> i1 + i2));


        //6
        //更或者先不转换，规约的时候再转换
        Stream.of(student1, student2, student3)
                .collect(Collectors.reducing(0, s -> ((Student) s).getName().length(), Integer::sum));
    }

    /**
     * 前后处理 分组
     */
    @Test
    public void demo6(){
        //Map<String,List<Integer>>
        Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(integer -> {
                    if (integer < 0) {
                        return "小于";
                    } else if (integer == 0) {
                        return "等于";
                    } else {
                        return "大于";
                    }
                }));

        //Map<String,Set<Integer>>
        //自定义下游收集器
        Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(integer -> {
                    if (integer < 0) {
                        return "小于";
                    } else if (integer == 0) {
                        return "等于";
                    } else {
                        return "大于";
                    }
                },Collectors.toSet()));

        //Map<String,Set<Integer>>
        //自定义map容器 和 下游收集器
        Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(integer -> {
                    if (integer < 0) {
                        return "小于";
                    } else if (integer == 0) {
                        return "等于";
                    } else {
                        return "大于";
                    }
                },LinkedHashMap::new,Collectors.toSet()));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
class Student{
    private long id;
    private String name;
}
