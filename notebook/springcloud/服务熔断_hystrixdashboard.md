# 服务熔断_hystrixdashboard
1. 添加依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```
2. 启动类添加注解@EnableHystrixDashboard
3. 注册断路器指标流Servlet,不然访问会报错Unable to connect to Command Metric Stream
```
@Configuration
public class HystrixDashboardConfigurer {
    /**
     * hystrix dashboar监控  注册断路器指标流Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
```
4. 访问http://localhost:8080/hystrix.(注:此处的ip和port即服务的ip和port)

https://www.cnblogs.com/fengfujie/p/11820535.html


http://localhost:8080/hystrix.stream：要监控路径url格式