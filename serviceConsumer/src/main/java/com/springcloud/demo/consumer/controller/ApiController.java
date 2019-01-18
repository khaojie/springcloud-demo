package com.springcloud.demo.consumer.controller;

import com.springcloud.demo.consumer.api.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private IApiService apiService;

    @RequestMapping("hello")
    public String hello(){
        return apiService.hello("comanche");
    }
}
