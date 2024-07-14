package com.haejun.springpractice.exec5.service;


import com.haejun.springpractice.exec5.dto.Member;

/**
 * packageName    : com.haejun.springpractice.exec1.discount.service
 * fileName       : DiscountPolicy
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public interface DiscountPolicy {
    int discount(Member member, int price);
}
