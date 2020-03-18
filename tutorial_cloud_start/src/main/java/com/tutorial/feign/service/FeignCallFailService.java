package com.tutorial.feign.service;

import org.springframework.stereotype.Service;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
@Service
public class FeignCallFailService implements BookFeignHystrixService {

    @Override
    public String bookFeign() {
        String message = "Feign--网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
        return message;
    }
}
