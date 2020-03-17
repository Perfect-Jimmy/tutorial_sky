package com.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: jimmy
 * @Date: 2020/3/17
 */
@RestController()
@RequestMapping("/consul")
public class ServerController {
   /* @Autowired
    private LoadBalancerClient loadBalancerClient;*/
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有注册的服务
     */
    @RequestMapping("/services")
    public void services(){
        List<ServiceInstance> instances = discoveryClient.getInstances("spring_cloud_book_server");
        System.out.println(instances.toString());
        List<ServiceInstance> instances2 = discoveryClient.getInstances("spring-cloud-book-server");
        System.out.println("2==="+instances2.toString());
    }


    public void getOne(){
        //loadBalancerClient.choose("consul-producer").toString();
        //loadBalancer.choose("service-producer").getUri().toString();
    }
}
