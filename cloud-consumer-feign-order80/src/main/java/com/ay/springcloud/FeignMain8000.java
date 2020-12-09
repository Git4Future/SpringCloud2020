package com.ay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月16日
 */
@SpringBootApplication
@EnableFeignClients
public class FeignMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain8000.class,args);
    }
}
