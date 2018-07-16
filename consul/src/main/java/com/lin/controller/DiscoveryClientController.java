package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DiscoveryClientController {
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/producers")
    public List index(@RequestParam String name,HttpServletRequest request) {


        List list =discoveryClient.getInstances("consul-client");
        System.out.println(request.getLocalPort());

        return list;
    }
}