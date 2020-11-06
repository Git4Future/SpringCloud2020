package com.ay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月04日
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    private String paymentzk(){
        return "springcloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
