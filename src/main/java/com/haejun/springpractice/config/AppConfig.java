package com.haejun.springpractice.config;

import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.discount.service.OrderService;
import com.haejun.springpractice.exec1.discount.service.impl.FixDiscountPlicy;
import com.haejun.springpractice.exec1.discount.service.impl.OrderServiceImpl;
import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.MemoryMemberRepository;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;

/**
 * packageName    : com.haejun.springpractice.config
 * fileName       : AppConfig
 * author         : NAHAEJUN
 * date           : 2024-06-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-27        NAHAEJUN              최초생성
 */
public class AppConfig {
    
    /**
     * AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
     * 
     * */
    
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new FixDiscountPlicy(),new MemoryMemberRepository());
//    }

    /**
     * 리팩토링 모든 역할 다 한눈에 보여야 한다. 그리고 중복되는 코드가 존재한다.
     * MemoryMemberRepository()
     *
     * */

    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(),getMemberRepository());
    }
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPlicy();
    }
}
