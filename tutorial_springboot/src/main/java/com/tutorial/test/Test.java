package com.tutorial.test;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

import java.util.Locale;

/**
 * @author jimmy
 * @date 2020/4/30
 */
public class Test {
    public static void main(String[] args) {
        Locale locale = LocaleContextHolder.getLocale();

        System.out.println(locale);
       // String name = "11";
       // Assert.hasText(name, "Name must not be empty");
    }
}
