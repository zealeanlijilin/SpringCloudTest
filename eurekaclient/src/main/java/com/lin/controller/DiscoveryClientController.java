package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryClientController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc/{serviceName}")
    public List<ServiceInstance> dc(@PathVariable String serviceName) {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return discoveryClient.getInstances(serviceName);
    }
}