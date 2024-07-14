package com.haejun.springpractice.beanfind;

import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.discount.service.impl.FixDiscountPlicy;
import com.haejun.springpractice.exec1.discount.service.impl.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * packageName    : com.haejun.springpractice.beanfind
 * fileName       : ApplicationContextExtendsFind
 * author         : NAHAEJUN
 * date           : 2024-07-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-01        NAHAEJUN              최초생성
 */
public class ApplicationContextExtendsFind {
    /**
     * 실질적으로 ApplicationContext를 이용해 실질적으로 Bean을 조회하거나
     * 매핑할일이 많지는 않다. 보통 생성자, 필드 주입 방식으로 스프링 컨테이너가 자동화로 넣어주기도 하고
     * 실직적으로  ApplicationContext를 이용해 실질적으로 Bean을 조회해서 사용하는경우가 매우 드물다.
     *  가끔 순수한 자바에서 스프링 컨테이너를 이용해 Bean을 꺼내서 사용해야하는경우가 있기때문에 알아둬야한다.
     * */
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 중복 오류가 발생한다.")
    void findParentsBean(){
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 , 빈이름을 지정하면 된다.")
    void findParentsBeanName() {
        DiscountPolicy bean = ac.getBean("discountPolicy",DiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findParentsBeanRowType() {
        // 하지만 해당 방법은 지양 하자, 역할 (인터페이스)의 의존이 아닌 직접 구현체에 의존함으로
        // solid의 원칙을 위반한다.
        DiscountPolicy bean = ac.getBean(FixDiscountPlicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 전부 조회")
    void findParentsBeanAllType() {
        Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beans.keySet()) {
            System.out.println("key = " + key + ", value = " + beans.get(key));
        }
    }

    @Test
    @DisplayName("모두의 조상 타입 으로 전부 조회 - Object")
    void findParentsBeanObjectType() {

        Map<String, Object> beans = ac.getBeansOfType(Object.class);
        for (String key : beans.keySet()) {
            System.out.println("key = " + key + ", value = " + beans.get(key));
        }
    }
    


    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy discountPolicy() {
            return new FixDiscountPlicy();
        }

        @Bean
        public DiscountPolicy discountPolicy2() {
            return new RateDiscountPolicy();
        }

    }

}
