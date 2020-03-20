# 网关路由规则_gateway
## application.yml配置

### route组成
* id:路由的ID
* uri:匹配路由的转发地址
* predicates:配置该路由的断言,通过PredicateDefinition类进行接收配置
* filter:过滤器,用于发送和返回请求之前,修改请求和响应

### predicate 断言,可以理解为:当满足这种条件后才会被转发,如果是多个,那就是都满足的情况下被转发
* 不同谓词之间可以组合使用,它们同时存在于同一个路由时,请求必须同时满足所有的谓词条件才被这个路由匹配
* 一个请求满足多个路由的谓词条件时,请求只会被首个成功匹配的路由转发
```
after
before
between
cookie
header
host
method
path
query
readBody
remoteAddr
weight
cloudFoundry
```


### filter  https://www.jianshu.com/p/5e40bbc95eb9
过滤器的种类
* GatewayFilter Factories:过滤器工厂生成的网关过滤器
* Global Filters:全局过滤器

#### 网关过滤器
* StripPrefix 过滤器:去掉部分URL路径
```
gateway:
  routes:
  - id: book
    uri: lb://spring-cloud-book-server
    predicates:
    - Path=/book/bookTest
    filters:
    - StripPrefix=1
访问http://localhost:8181/book/bookTest
不配StripPrefix,最终访问http://spring-cloud-book-server/book/bookTest
配置StripPrefix,最终访问http://spring-cloud-book-server/bookTest,会去掉一个前缀/book


```
* PrefixPath 过滤器,与StripPrefix相反
* Hystrix 过滤器:将断路器引入网关路由,保护服务免受级联故障的影响,并在下游故障时提供回退响应

#### 全局过滤器
* LoadBalancerClient负载均衡过滤器
```
当路由配置中uri所用的协议为lb时(uri: lb://spring-cloud-producer),gateway将使用LoadBalancerClient把spring-cloud-producer通过consul解析为实际的主机和端口并进行负载均衡
```
* Netty Routing Filter
```
当路由配置中uri所用的协议为http或者https时,netty路由过滤器就会启用,使用Netty的HttpClient转发请求给网关后面的服务
```
* Websocket Routing Filter
```
当路由配置中uri所用的协议为ws或者wss时,Websocket路由过滤器就会启用
```

https://www.jianshu.com/p/35b60946b8ce
https://github.com/14251104246/spring-cloud-gateway-demo/blob/Predicate/spring-cloud-gateway/src/main/resources/application.yml
https://www.zhangshengrong.com/p/Z9a28qZkXV/















## 通过@Bean注解RouteLocator配置