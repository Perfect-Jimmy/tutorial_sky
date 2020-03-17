package com.tutorial.controller;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.Check;
import com.ecwid.consul.v1.health.model.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 剔除已注销的实例  http://blog.didispace.com/consul-deregister/
 * @Author: jimmy
 * @Date: 2020/3/17
 */
@RestController
//@RequestMapping("/delUnregisterInstance")
public class DelUnregisterController {
    @Autowired
    private ConsulClient consulClient;

    @RequestMapping("/delUnregisterInstance/{id}")
    public void delUnregisterInstance(@PathVariable String id){
        List<HealthService> response = consulClient.getHealthServices(id, false, null).getValue();
        for(HealthService service : response) {
            // 创建一个用来剔除无效实例的ConsulClient，连接到无效实例注册的agent
            ConsulClient clearClient = new ConsulClient(service.getNode().getAddress(), 8500);
            service.getChecks().forEach(check -> {
                if(check.getStatus() != Check.CheckStatus.PASSING) {
                   // logger.info("unregister : {}", check.getServiceId());
                    clearClient.agentServiceDeregister(check.getServiceId());
                }
            });
        }
    }


  /*  @RequestMapping(value = "/unregister/{id}", method = RequestMethod.POST)
    public String unregisterServiceAll(@PathVariable String id) {
        List<HealthService> response = consulClient.getHealthServices(id, false, null).getValue();
        for(HealthService service : response) {
            service.getChecks().forEach(check -> {
                if(!check.getStatus().name().equals(Check.CheckStatus.PASSING.name())) {
                    logger.info("unregister : {}", check.getServiceId());
                    consulClient.agentServiceDeregister(check.getServiceId());
                }
            });
        }
        return null;
    }*/
}
