# 服务熔断_hystrix
## 添加依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```
## ribbon 方式
1. 启动类添加注解@EnableHystrix 
2. 使用注解
```
@Autowired
private RestTemplate restTemplate;

/**
 * @HystrixCommand 服务调用失败的回调方法 fallbackMethod = "getInfoFailure"
 * @return
 */
@HystrixCommand(fallbackMethod = "getInfoFailure")
public String ribbonHystrixCall(){
    String method = "bookTest";
    restTemplate.getForEntity("http://spring-cloud-book-server/" + method, String.class).getBody();
    return "ribbon call success";
}

public String getInfoFailure() {
    String message = "网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
    return message;
}
```
3. 调用



## feign方式
1. 启动类添加注解@EnableHystrix 
2. yml添加配置
```
feign:
  hystrix:
    enabled: true #开启feign熔断
```
3. 调用
错误回调类
```
@Service
public class FeignCallFailService implements BookFeignHystrixService {

    @Override
    public String bookFeign() {
        String message = "Feign--网络繁忙，请稍后再试-_-。PS：服务消费者自己提供的信息";
        return message;
    }
}
```
声明feign接口,fallback指定错误回调类
```
@FeignClient(value = "spring-cloud-book-server",fallback = FeignCallFailService.class)
public interface BookFeignHystrixService {
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
private BookFeignHystrixService bookFeignHystrixService;

@GetMapping(value = "/feignHystrixCall")
public String feignHystrixCall(){
    return bookFeignHystrixService.bookFeign();
}
```

