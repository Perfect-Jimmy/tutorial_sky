# 服务发现_ribbon 客户端RestTemplate负载均衡组件
1. 添加依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```
2. 轮询查询
```
@Autowired
private LoadBalancerClient loadBalancerClient;

@RequestMapping("/chooseOne")
public void chooseOne(){
    ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-book-server");
    System.out.println(serviceInstance.toString());
    System.out.println(serviceInstance.getUri().toString());
}
```
consul上注册2个book server服务,端口9080,9081.多次调用此接口会交替去访问这两个服务


3. 负载均衡
```
@Bean
@LoadBalanced
RestTemplate restTemplate(){
    return new RestTemplate();
}
```
```
@Autowired
private RestTemplate restTemplate;

@GetMapping(value = "/ribbonCall")
public String ribbonCall() {
    String method = "bookTest";
    return restTemplate.getForEntity("http://spring-cloud-book-server/" + method, String.class).getBody();
}
```
http://spring-cloud-book-server/即book server注册到consul上的名字


