package com.ay.myruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kinglone
 * @version 1.0.0
 * @date 2020年11月12日
 */
@Configuration
public class MySelfRuler {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
