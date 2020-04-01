package com.tutorial.feign.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
//被调用的服务在consul注册的名称
//@FeignClient(value = "spring-cloud-book-server")
public interface BookFeignService {

    /**
     * bookFeign为spring-cloud-book-server服务对外提供的接口
     * @return
     */
    @RequestMapping(value = "/bookFeign")
    String bookFeign();
}
