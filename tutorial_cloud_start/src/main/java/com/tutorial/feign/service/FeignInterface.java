package com.tutorial.feign.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jimmy
 * @date 2020/3/31 16:21
 */
//@FeignClient(name = "spring-cloud-start")
public interface FeignInterface {
    @RequestMapping(value = "/feign/feignTest")
    public String feignTest();
}
