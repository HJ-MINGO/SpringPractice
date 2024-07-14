package com.haejun.springpractice.exec5.service.impl;

import com.haejun.springpractice.exec5.dto.Order;
import com.haejun.springpractice.exec5.service.OrderService;
import com.haejun.springpractice.exec5.dto.Member;
import com.haejun.springpractice.exec5.repo.MemberRepository;
import com.haejun.springpractice.exec5.service.DiscountPolicy;
import com.haejun.springpractice.exec5.service.OrderService;

/**
 * packageName    : com.haejun.springpractice.exec1.discount.service.impl
 * fileName       : OrderServiceImpl
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public class OrderServiceImpl implements OrderService {


    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
