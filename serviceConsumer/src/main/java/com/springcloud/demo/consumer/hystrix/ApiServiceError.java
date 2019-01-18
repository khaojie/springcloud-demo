package com.springcloud.demo.consumer.hystrix;

import com.springcloud.demo.consumer.api.IApiService;
import org.springframework.stereotype.Component;

@Component
public class ApiServiceError implements IApiService {

    @Override
    public String hello(String name) {
        return "服务发生故障！";
    }
}

