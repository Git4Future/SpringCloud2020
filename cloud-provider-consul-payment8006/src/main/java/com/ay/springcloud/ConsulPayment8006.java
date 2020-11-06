package com.ay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月06日
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPayment8006 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulPayment8006.class,args);
    }
}
