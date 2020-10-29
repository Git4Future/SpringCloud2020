package com.ay.springcloud.service;

import com.ay.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年10月22日
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
