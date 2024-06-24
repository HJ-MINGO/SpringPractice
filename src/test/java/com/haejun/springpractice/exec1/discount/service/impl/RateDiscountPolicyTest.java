package com.haejun.springpractice.exec1.discount.service.impl;

import com.haejun.springpractice.exec1.member.Grade;
import com.haejun.springpractice.exec1.member.dto.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.haejun.springpractice.exec1.discount.service.impl
 * fileName       : RateDiscountPolicyTest
 * author         : NAHAEJUN
 * date           : 2024-06-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-25        NAHAEJUN              최초생성
 */
class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 하일인 적용되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
//        assertAll()
    }

}