/**
 * 
 * 项目名称：tikie-eureka-client
 * 创建日期：2018年6月27日
 * 修改历史：
 * 		1、[2018年6月27日]创建文件 by zhaocs
 */
package com.tikie.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaocs
 *
 */
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;
    
    @GetMapping("/client")
    public String client() {
        String services = "Services: " + discoveryClient.getServices()+" port :" + port;
        
        System.out.println(services);
        return services;
    }
    
    @GetMapping("/hi")
    public String Home(@RequestParam String name){
        return "hi "+name+",i am from port:" + port;
    }
}
