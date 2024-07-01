package com.haejun.springpractice.exec1.member;

import com.haejun.springpractice.config.AppConfig;
import com.haejun.springpractice.config.AppSpringConfig;
import com.haejun.springpractice.exec1.member.dto.Member;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : com.haejun.springpractice.exec1.member
 * fileName       : MemberApp
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl();
//        MemberService memberService = appConfig.memberService();
        // 스프링 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppSpringConfig.class);
        /*
        * 정확히는 스프링 컨테이너를 부를때 BeanFactory, ApplicationContext로 구분해서 이야기 하며
        * BeanFactory를 직접 사용하는 경우는 거의 없으므로 일반적으로 ApplicationContext를 스프링 컨테이너라 칭한다.
        * 최상위에 BeanFactory가 존재하며 그아래에 ApplicationContext가 존재한다.
        * */
        MemberService memberService = context.getBean("memberService", MemberService.class);
        Member member =  new Member(1L,"해준",Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println(member);
        System.out.println(findmember);
        System.out.println("Member =" + member.getName());
        System.out.println("Find Member =" + findmember.getName());

    }
}
