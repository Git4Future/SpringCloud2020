package com.ay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月19日
 */
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
public class OrderHystrixMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8000.class,args);
    }

}
