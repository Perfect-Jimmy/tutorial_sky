# 网关配置_gateway
## application.yml配置

### predicate 断言,可以理解为:当满足这种条件后才会被转发,如果是多个,那就是都满足的情况下被转发
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
* path 


https://www.jianshu.com/p/35b60946b8ce
https://github.com/14251104246/spring-cloud-gateway-demo/blob/Predicate/spring-cloud-gateway/src/main/resources/application.yml
https://www.zhangshengrong.com/p/Z9a28qZkXV/















## 通过@Bean注解RouteLocator配置