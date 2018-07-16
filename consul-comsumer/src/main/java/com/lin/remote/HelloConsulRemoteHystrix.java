package com.lin.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloConsulRemoteHystrix implements HelloConsulRemote{
    @Override
    public String hello(String name) {
        return "系统熔断";
    }
}