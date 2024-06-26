package com.haejun.springpractice.exec1.discount;

import com.haejun.springpractice.config.AppConfig;
import com.haejun.springpractice.exec1.discount.dto.Order;
import com.haejun.springpractice.exec1.discount.service.OrderService;
import com.haejun.springpractice.exec1.discount.service.impl.OrderServiceImpl;
import com.haejun.springpractice.exec1.member.Grade;
import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.dto.Member;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;

/**
 * packageName    : com.haejun.springpractice.exec1.discount
 * fileName       : OrederApp
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public class OrederApp {

    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        // 이제 Appconfig사용
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order.toString());

    }
}
