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
    /**
     * 관심사의 분리
     * 애츨리케이션이 하나의 공연
     * 각각의 인터페이스는 배역(역할)
     * 그리고 해당 배역을 연기하는 연기자는 구현체(디카프리오,손석구 등등)
     *
     * 스프링을 적용하기 전 순수 자바로 개발한 OrderServiceImpl 은
     * DiscountPolicy인터페이스도 의존하고 해당 인터페이스를 구현한 구현체
     * FixDiscountPlicy , RateDiscountPolicy 들도 직접 의존하고있다.
     * 너무 많은걸 의존하고잇다.... 그래서 OrderServiceImpl는 자신의 역할에만 집중해야하는데
     * 이전 코드는 그러질 못하고있다.
     *
     *  그래서 이것을 해결하고자 애플리케이션의 전체 동작방식을 구성(config)하기 위해, 구현객체를 생성하고,
     *  "연결" 하는 책임을 가지는 별도의 설정 클래스를 만들어야 한다.
     *  그것이 SpringCofiguration 클래스
     * */
    @Bean
    public BeanMember beanMember() {
        return new BeanMember();
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
}
