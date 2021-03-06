package com.springcloud.demo.consumer.api;

import com.springcloud.demo.consumer.hystrix.ApiServiceError;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eurekaclient",fallback = ApiServiceError.class)
public interface IApiService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(String name);
}
