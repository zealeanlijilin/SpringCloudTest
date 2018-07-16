package com.lin.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="consul-client", fallback = HelloConsulRemoteHystrix.class)
public interface HelloConsulRemote {
    @RequestMapping(value = "/producers")
    public String hello(@RequestParam(value = "name") String name);
}
