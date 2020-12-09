package com.ay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年12月09日
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudGateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway9527.class,args);
    }
}
