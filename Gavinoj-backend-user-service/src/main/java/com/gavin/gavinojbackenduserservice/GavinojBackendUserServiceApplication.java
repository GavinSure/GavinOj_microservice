package com.gavin.gavinojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.gavin.gavinojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.gavin")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.gavin.gavinojbackendserviceclient.service"})
public class GavinojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GavinojBackendUserServiceApplication.class, args);
    }

}
