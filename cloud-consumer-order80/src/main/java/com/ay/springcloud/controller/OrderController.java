package com.ay.springcloud.controller;

import com.ay.springcloud.entities.CommonResult;
import com.ay.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年10月26日
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAMENT_URL = "http://localhost:8001";
    public static final String PAMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAMENT_URL+"payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
