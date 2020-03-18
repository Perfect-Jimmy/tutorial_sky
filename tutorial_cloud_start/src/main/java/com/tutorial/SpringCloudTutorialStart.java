package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jimmy
 * @Date: 2020/3/17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableFeignClients(basePackages = "com.tutorial.feign.service")
@EnableHystrix
public class SpringCloudTutorialStart {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTutorialStart.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
