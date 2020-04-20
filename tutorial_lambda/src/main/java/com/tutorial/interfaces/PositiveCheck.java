package com.tutorial.interfaces;

import com.tutorial.utils.BusinessCheckUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.function.Predicate;

/**
 * @author jimmy
 * @description
 * @date 2020/4/17 10:56
 */
public class PositiveCheck {

    public static boolean check(Predicate<Apple> predicate,Apple apple){
        return predicate.test(apple);

    }

    public static void main(String[] args) {
        Apple apple = new Apple().setId(9L).setColour("green").setBirth(new Date());
        boolean result = BusinessCheckUtil.check(apple.getId(),num->num>0);
        System.out.println(result);
    }
}

@Data
@Accessors(chain = true)
class Apple{
    private Long id;
    private String colour;
    private Date birth;
}
