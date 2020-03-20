package com.tutorial.configurer;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jimmy
 * @Date: 2020/3/20
 */
//@Configuration
public class GatewayPathConfigurer {

    /**
     * 当访问http://localhost:8181/bookTest便会转发到http://localhost:9080/bookTest
     * localhost:8181是网关服务地址
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bookServer", r ->
                        r.path("/bookTest").uri("http://localhost:9080"))
                .build();
    }
}
