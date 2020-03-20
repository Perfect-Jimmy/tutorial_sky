package com.tutorial.configurer;

import org.springframework.context.annotation.Configuration;

/**
 * 接口访问有时间限制
 * 可以通过Before Predicate来完成某一个时间点之前允许访问,过时后则不允许转发请求到具体的服务
 * @Author: jimmy
 * @Date: 2020/3/20
 */
@Configuration
public class GatewayBeforeConfigurer {
}
