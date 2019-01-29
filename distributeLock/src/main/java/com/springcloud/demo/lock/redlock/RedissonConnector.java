package com.springcloud.demo.lock.redlock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 获取RedissonClient连接类
 */
@Component
public class RedissonConnector {
    RedissonClient redisson;
    @Value("${spring.redis.host}")
    private String redisIp;
    @Value("${spring.redis.port}")
    private String redisPort;
    @Value("${spring.redis.password}")
    private String redispasswd;

    @PostConstruct
    public void init(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+redisIp+":"+redisPort).setPassword(redispasswd)
                .setRetryAttempts(10)
                .setTimeout(6000);//Response timeout

        redisson = Redisson.create(config);

    }

    public RedissonClient getClient(){
        return redisson;
    }
}
