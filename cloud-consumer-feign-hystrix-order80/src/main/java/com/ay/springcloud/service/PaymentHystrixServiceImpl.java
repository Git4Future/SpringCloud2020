package com.ay.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月20日
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "==> PaymentHystrixService 类的  paymentInfo_OK 方法 FALLBACK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "==> PaymentHystrixService 类的  paymentInfo_Timeout 方法 FALLBACK";
    }
}
