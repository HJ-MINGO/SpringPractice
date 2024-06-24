package com.haejun.springpractice.exec1.discount.service.impl;

import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.member.Grade;
import com.haejun.springpractice.exec1.member.dto.Member;

/**
 * packageName    : com.haejun.springpractice.exec1.discount.service.impl
 * fileName       : RateDiscountPolicy
 * author         : NAHAEJUN
 * date           : 2024-06-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-25        NAHAEJUN              최초생성
 */
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }

    }
}
