package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RefreshScope
@RestController
public class DiscoveryClientController {
    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${config.mode}")
    private String hello;


    @RequestMapping("/producers")
    public List index(@RequestParam String name,HttpServletRequest request) {


        List list =discoveryClient.getInstances("consul-client");
        System.out.println(request.getLocalPort());

        return list;
    }
    @RequestMapping("/getConfigs")
    public String getConfigs() {
        return this.hello;
    }
}