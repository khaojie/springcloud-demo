package com.springcloud.demo.consumer.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eurekaclient")
public interface IApiService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();
}
