package com.tutorial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @EnableCaching 注解开启缓存
 * @Author: jimmy
 * @Date: 2020/3/25
 */
@SpringBootApplication
@MapperScan(basePackages = "com.tutorial.repository.*")
@EnableCaching
public class MybatisStart {
    public static void main(String[] args) {
        SpringApplication.run(MybatisStart.class,args);
    }
}
