package com.springcloud.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;


@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class,args);
    }

    @Bean
    @Primary
    public MySQLStorage mySQLStorage(DataSource dataSource) {
        return MySQLStorage.builder().datasource(dataSource).executor(Runnable::run).build();
    }
}
