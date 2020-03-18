package com.tutorial.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
@FeignClient(value = "spring-cloud-book-server",fallback = FeignCallFailService.class)
public interface BookFeignHystrixService {
    /**
     * bookFeign为spring-cloud-book-server服务对外提供的接口
     * @return
     */
    @RequestMapping(value = "/bookFeign")
    String bookFeign();
}
