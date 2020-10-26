package com.ay.springcloud.controller;

import com.ay.springcloud.entities.CommonResult;
import com.ay.springcloud.entities.Payment;
import com.ay.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年10月22日
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("==> 插入结果：" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功",result);
        }else {
            return new CommonResult(500,"插入数据失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("==> 查询结果：" + payment);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(500,"没有"+id+"记录,查询失败",null);
        }
    }
}
