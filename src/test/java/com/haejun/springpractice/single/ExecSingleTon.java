package com.haejun.springpractice.single;

import com.haejun.springpractice.config.AppSpringConfig;
import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.discount.service.OrderService;
import com.haejun.springpractice.exec1.discount.service.impl.FixDiscountPlicy;
import com.haejun.springpractice.exec1.discount.service.impl.OrderServiceImpl;
import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.MemoryMemberRepository;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.haejun.springpractice.single
 * fileName       : ExecSingleTon
 * author         : NAHAEJUN
 * date           : 2024-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-04        NAHAEJUN              최초생성
 */
public class ExecSingleTon {

    
        @Test
        @DisplayName("싱글톤 컨테이너 테스트")
        public void test2(){

            // 이렇게  new SingleTonEx1() 으로 직접 @Configuration클래스를
            // 사용하는거 스프링 컨테이너 관리 밖에 있게되어서 스프링의 온전한 관리를 받지않아
            // 싱글톤을 잃게 된다.
            AppSpringConfig singleTonEx1 = new AppSpringConfig();
            MemberService memberService = singleTonEx1.memberService();
            MemberService memberService2 = singleTonEx1.memberService();

            System.out.println(memberService); // 주소다름
            System.out.println(memberService2); // 주소다름

            // 공식적으로 스프링컨테이너의 등록 빈들은 자동으로 싱글톤으로 작동한다.
            ApplicationContext ac = new AnnotationConfigApplicationContext(AppSpringConfig.class);
            MemberService memberService3 = ac.getBean("memberService", MemberService.class);
            MemberService memberService4 = ac.getBean("memberService",MemberService.class);
            System.out.println(memberService3);
            System.out.println(memberService4);


            AppSpringConfig appSpringConfig = ac.getBean(AppSpringConfig.class);
            MemberService memberService5 = appSpringConfig.memberService();
            MemberService memberService6 = appSpringConfig.memberService();

            System.out.println(memberService5);
            System.out.println(memberService6);


        }

}
