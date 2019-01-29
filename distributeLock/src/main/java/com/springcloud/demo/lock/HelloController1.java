package com.springcloud.demo.lock;

import com.springcloud.demo.lock.redlock.AquiredLockWorker;
import com.springcloud.demo.lock.redlock.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

    @Autowired
    private DistributedLocker distributedLocker;

    @RequestMapping("index1")
    public String index()throws Exception{
        distributedLocker.lock("test",new AquiredLockWorker<Object>() {
            @Override
            public Object invokeAfterLockAquire() {
                try {
                    System.out.println("执行方法！");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }

        });
        return "hello world!";
    }
}
