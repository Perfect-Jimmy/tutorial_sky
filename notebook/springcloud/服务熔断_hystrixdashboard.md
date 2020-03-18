# 服务熔断_hystrixdashboard
1. 添加依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```
2. 启动类添加注解@EnableHystrixDashboard
3. 访问http://localhost:8080/hystrix.(注:此处的ip和port即服务的ip和port)

https://www.cnblogs.com/fengfujie/p/11820535.html


http://localhost:8080/hystrix.stream：要监控路径url格式