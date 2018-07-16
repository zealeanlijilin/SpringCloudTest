package com.lin.controller;

import com.lin.remote.HelloConsulRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloConsulRemote helloConsulRemote;
    @GetMapping("/hello")
    public String hello(){
        System.out.println("dddddddd");
       return helloConsulRemote.hello("ddd");
    }
}