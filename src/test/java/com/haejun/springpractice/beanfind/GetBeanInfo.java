package com.haejun.springpractice.beanfind;

import com.haejun.springpractice.config.AppSpringConfig;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : com.haejun.springpractice.beanfind
 * fileName       : GetBeanInfo
 * author         : NAHAEJUN
 * date           : 2024-07-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-01        NAHAEJUN              최초생성
 */
public class GetBeanInfo {
    /**
     * 스프링 컨테이너에서 스프링 빈을 찾는 가장 기본적인 방법
     * ex ) ac.getBean(빈이름, 타입);
     *      ac.getBean(타입)
     * 조회 대상 스프링 빈이 없으면 예외 발생
     * ex ) NoSuchBeanDefinitionException: No bean named 'xxxxx' available
     *
     * */
     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppSpringConfig.class);

     @Test
     @DisplayName("빈이름으로 조회")
     void findGetBeanInfo() {
         MemberService memberService = ac.getBean("memberService", MemberService.class);
         System.out.println("memberService = " + memberService);
         System.out.println("memberService.getClass() = " + memberService.getClass());
         
     }
     
     @Test
     @DisplayName("타입으로 조회")
     void findGetBeanInfoType() {
         MemberService memberService = ac.getBean(MemberService.class);
         System.out.println("memberService = " + memberService);
         System.out.println("memberService.getClass() = " + memberService.getClass());
         
     }

     @Test
     @DisplayName("구체타입으로 조회")
     void findGetBeanInfoImplType() {
         MemberService memberService = ac.getBean(MemberServiceImpl.class);
         System.out.println("memberService = " + memberService);
         System.out.println("memberService.getClass() = " + memberService.getClass());

     }
}
