package com.springcloud.demo.consumer.test;


import com.springcloud.demo.consumer.ConsumerApplication;
import com.springcloud.demo.consumer.api.IApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = ConsumerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDB {
    @Autowired
    private IApiService apiService;

    @Test
    public void test() throws Exception{
        try {
            System.out.println(apiService.hello());
        }catch (Exception e){
            throw e;
        }
    }
}
