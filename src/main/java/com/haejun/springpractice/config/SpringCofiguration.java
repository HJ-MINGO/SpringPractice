package com.haejun.springpractice.config;

import com.haejun.springpractice.aop.TimeTraceAop;
import com.haejun.springpractice.service.BeanMember;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.haejun.springpractice.config
 * fileName       : SpringCofiguration
 * author         : NAHAEJUN
 * date           : 2024-06-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-16        NAHAEJUN              최초생성
 */
@Configuration
public class SpringCofiguration {

    @Bean
    public BeanMember beanMember() {
        return new BeanMember();
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
}
