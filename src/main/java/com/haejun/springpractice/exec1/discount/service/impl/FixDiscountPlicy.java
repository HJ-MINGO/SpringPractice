package com.haejun.springpractice.exec1.discount.service.impl;

import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.member.Grade;
import com.haejun.springpractice.exec1.member.dto.Member;

/**
 * packageName    : com.haejun.springpractice.exec1.discount.service.impl
 * fileName       : FixDiscountPlicy
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public class FixDiscountPlicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
