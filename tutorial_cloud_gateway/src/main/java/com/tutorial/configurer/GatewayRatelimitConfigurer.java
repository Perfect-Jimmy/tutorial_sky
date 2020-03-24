package com.tutorial.configurer;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * burstCapacity:令牌桶总容量
 * replenishRate:令牌桶每秒填充平均速率
 * key-resolver:用于限流的键的解析器的Bean对象的名字
 * 使用SpEL表达式根据#{@beanName}从Spring容器中获取Bean对象
 * @Author: jimmy
 * @Date: 2020/3/24
 */
@Configuration
public class GatewayRatelimitConfigurer {

    @Bean
    public KeyResolver uriKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }

    /**
     * 获取请求用户ip作为限流key
     * @return
     */
    @Bean
    public KeyResolver hostAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * 获取请求用户id作为限流key
     * @return
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }

    /**
     * 获取请求地址的uri作为限流key
     * @return
     */
    @Bean
    KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
}
