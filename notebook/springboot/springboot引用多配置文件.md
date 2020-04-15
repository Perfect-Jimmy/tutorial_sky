# springboot引用多配置文件
```
spring:
  profiles:
    active: dev
    include:
    - thread
```
一定要有一个文件application-thread.yml文件