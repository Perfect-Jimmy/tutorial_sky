# 注册中心_consul  http://blog.didispace.com/spring-cloud-learning/
特性:服务发现  健康检查  k/v存储  多数据中心

## 安装(windows)
1. 下载地址https://www.hashicorp.com/products/consul
2. 解压,例D:\consul_1.7.2_windows_amd64
3. 添加环境变量 Path
4. cmd窗口命令执行:consul agent -dev,访问http://localhost:8500
5. cmd窗口命令执行:consul.exe agent -server ui -bootstrap -client 0.0.0.0 -data-dir="E:\consul" -bind X.X.X.X(其中X.X.X.X为服务器ip,即可使用http://X.X.X.X:8500)



## 安装(docker)



## 安装(mac)
./consul agent -dev -client=0.0.0.0
--client 用0.0.0.0表示不限客户端(调用方)的IP

注意: OS X 用户：Consul 使用 hostname 做 node name，如果 node name 包含句点，会导致 DNS 无法工作，所以需要显式设置 node name 用 -node flag

./consul agent -dev -client=0.0.0.0 -node=node0



## 集成consul
1. 添加依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-consul-discovery</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
2. 在启动类上添加注解@EnableDiscoveryClient,使应用程序成为Consul"服务"（即注册自己）和"客户端"（即可以查询Consul查找其他服务）
