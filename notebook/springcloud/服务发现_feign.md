# 服务发现_feign 声明式服务调用,简化RestTemplate使用
1. 添加依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
2. 启动类添加注解@EnableFeignClients
3. 负载均衡
声明一个接口,value值为需要调用的服务注册到consul里面的服务名字
```
@FeignClient(value = "spring-cloud-book-server")
public interface BookFeignService {

    /**
     * bookFeign为spring-cloud-book-server服务对外提供的接口
     * @return
     */
    @RequestMapping(value = "/bookFeign")
    String bookFeign();
}
```
调用
```
@Autowired
private BookFeignService bookFeignService;

@RequestMapping("/feignCall")
public String feignCall() {
    String message = bookFeignService.bookFeign();
    return "获取到的信息:" + message;
}
```