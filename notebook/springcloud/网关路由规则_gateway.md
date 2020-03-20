# 网关路由规则_gateway
## application.yml配置

### route组成
* id:路由的ID
* uri:匹配路由的转发地址
* predicates:配置该路由的断言,通过PredicateDefinition类进行接收配置

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


https://www.jianshu.com/p/35b60946b8ce
https://github.com/14251104246/spring-cloud-gateway-demo/blob/Predicate/spring-cloud-gateway/src/main/resources/application.yml
https://www.zhangshengrong.com/p/Z9a28qZkXV/















## 通过@Bean注解RouteLocator配置