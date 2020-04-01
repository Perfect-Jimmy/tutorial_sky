package com.tutorial.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jimmy
 * @date 2020/3/31 17:01
 */
@FeignClient(name = "spring-cloud-book-server")
public interface BookFeignInterface {

    @RequestMapping("/bookTest")
    void getBook();
}
