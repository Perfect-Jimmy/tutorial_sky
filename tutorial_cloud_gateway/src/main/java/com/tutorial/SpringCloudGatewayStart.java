package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGatewayStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayStart.class,args);
    }
}
