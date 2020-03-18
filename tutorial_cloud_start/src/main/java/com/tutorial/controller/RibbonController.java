package com.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/chooseOne")
    public void chooseOne(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-book-server");
        System.out.println(serviceInstance.toString());
        System.out.println(serviceInstance.getUri().toString());
    }

    /**
     * 负载均衡查询
     * @return
     */
    @GetMapping(value = "/ribbonCall")
    public String ribbonCall() {
        String method = "bookTest";
        return restTemplate.getForEntity("http://spring-cloud-book-server/" + method, String.class).getBody();
    }

}
