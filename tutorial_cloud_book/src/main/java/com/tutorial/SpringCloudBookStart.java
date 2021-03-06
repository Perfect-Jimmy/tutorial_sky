package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: jimmy
 * @Date: 2020/3/17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudBookStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBookStart.class,args);
    }
}
