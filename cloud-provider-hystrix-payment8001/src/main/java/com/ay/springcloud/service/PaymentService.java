package com.ay.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月19日
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_OK,id:    "+id+"\t 哈哈哈!";
    }

    /**
     * 配置服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //int age = 9/0;
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id:  "+id+"\t  哦哦哦! 耗时: "+timeNumber +  "秒";
    }

    /**
     * 服务降级方法
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOutHandler,id:  "+id+"\t ,系统繁忙,我来fallback处理!";
    }


    /**
     * 熔断器
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack" ,commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("=======> id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号为:"+serialNumber;
    }

    /**
     * 熔断器降级方法
     * @param id
     * @return
     */
    public String paymentCircuitBreakerFallBack(@PathVariable("id") Integer id){
        return "==> 我是[paymentCircuitBreakerFallBack], id 不能为负数,请稍后再试,/(ㄒoㄒ)/~~!";
    }
}
