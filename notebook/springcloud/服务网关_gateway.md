# 服务网关_gateway
## 名词概念
* Route(路由):网关的基本模块,它有一个id、一个目标uri、一组断言和一组过滤器组成,如果断言为真,则路由匹配
* Predicate(断言):是一个java8的Predicate。输入类型是一个ServerWebExchange.可以使用它来匹配来自HTTP请求的内容
* Filter(过滤器):是org.springframework.cloud.gateway.filter.GatewayFilter的实例,可以使用它来修改请求和响应

1. 添加依赖
```
<!--因为spring cloud gateway是基于webflux的,不要导入spring-boot-start-web-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

## 入门例子
配置路由规则
```
@Bean
public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(p -> p
        .path("/get") // intercept calls to the /get path
        .filters(f -> f.addRequestHeader("Hello", "World")) // add header
        .uri("http://httpbin.org:80")) // forward to httpbin
        .build();
}
在浏览器请求http://localhost:8181/get
```
任何请求http://localhost:8181/get都将与此路由指令匹配,此配置对请求进行两次更改:
filters()方法处理诸如添加或更改标题之类的事情,示例中将Hello标题设置为值World,此外该uri()方法将请求转发给新主机




https://www.jianshu.com/p/35b60946b8ce