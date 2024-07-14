package com.haejun.springpractice.config;

import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.discount.service.OrderService;
import com.haejun.springpractice.exec1.discount.service.impl.FixDiscountPlicy;
import com.haejun.springpractice.exec1.discount.service.impl.OrderServiceImpl;
import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.MemoryMemberRepository;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.haejun.springpractice.config
 * fileName       : AppSpringConfig
 * author         : NAHAEJUN
 * date           : 2024-06-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-30        NAHAEJUN              최초생성
 */
public class NoAppSpringConfig {
    /**
     * 리팩토링 모든 역할 다 한눈에 보여야 한다. 그리고 중복되는 코드가 존재한다.
     * MemoryMemberRepository()
     *
     * */
    @Bean
    public MemberService memberService(){
        System.out.println("MemberServiceImpl ~ ");
        return new MemberServiceImpl(getMemberRepository());
    }
    @Bean
    public OrderService orderService(){
        System.out.println("orderService ~ ");
        return new OrderServiceImpl(discountPolicy(),getMemberRepository());
    }
    @Bean
    public MemberRepository getMemberRepository() {
        System.out.println("MemoryMemberRepository ~ ");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPlicy();
    }
}
