package com.tutorial.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
@Service
public class BookRibbonService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @HystrixCommand 服务调用失败的回调方法 fallbackMethod = "getInfoFailure"
     * @return
     */
    @HystrixCommand(fallbackMethod = "getInfoFailure")
    public String ribbonHystrixCall(){
        String method = "bookTest";
        restTemplate.getForEntity("http://spring-cloud-book-server/" + method, String.class).getBody();
        return "ribbon call success";
    }

    public String getInfoFailure() {
        String message = "网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
        return message;
    }
}
