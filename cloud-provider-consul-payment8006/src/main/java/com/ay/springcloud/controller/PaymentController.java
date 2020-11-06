package com.ay.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月06日
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    private String paymentconsul(){
        return "springcloud with consul" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
