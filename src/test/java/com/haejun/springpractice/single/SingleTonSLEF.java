package com.haejun.springpractice.single;

import com.haejun.springpractice.config.AppSpringConfig;
import com.haejun.springpractice.config.NoAppSpringConfig;
import com.haejun.springpractice.exec1.discount.service.OrderService;
import com.haejun.springpractice.exec1.discount.service.impl.OrderServiceImpl;
import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : com.haejun.springpractice.single
 * fileName       : SingleTonSLEF
 * author         : NAHAEJUN
 * date           : 2024-07-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-07        NAHAEJUN              최초생성
 */
public class SingleTonSLEF {

    @Test
    @DisplayName("@Configuration 사용시 싱글톤 적용방식")
    public void sigleTonTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppSpringConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("getMemberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberServiceRepo();
        MemberRepository memberRepository2 = orderService.getMemberRepository();


        System.out.println("memberRepository1 : " + memberRepository1);
        System.out.println("memberRepository2 : " + memberRepository2);
        System.out.println("memberRepository : " +memberRepository);


    }

    @Test
    @DisplayName("CGLIB는 무엇인가")
    public void cglibTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppSpringConfig.class);
        AppSpringConfig aps = ac.getBean(AppSpringConfig.class);
        System.out.println(aps); // com.haejun.springpractice.config.AppSpringConfig$$SpringCGLIB$$0@3c7c886c

        /**
         * 순스한 클래스로 생성시에는 com.haejun.springpractice.config.AppSpringConfig
         *
         * 하지만, 스프링에서  CBLIB라는 바이트코드 조작 라이브러리 이용해서
         * AppSpringConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를
         * 스프링 bean으로 등록한것이다.
         *
         * 즉, 실제 AppSpringConfig클래스를 이용해 인스턴스를 만든게 아니라
         * CGLIB라는 바이트코드를 조작해서 AppSpringConfig클래스를 상속받은 $$SpringCGLIB 클래스 를 만들어서
         * 인스턴스를 생성해 빈으로 등록한것이다.
         *
         *
         *
         * */
    }

    @Test
    @DisplayName("@Configruation 없이 @Bean만 사용시")
    public void noConfigTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(NoAppSpringConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        /**
         * @Configuration 사용없이도 @Bean 어노테이션 만으로도 스프링 컨테이너의 Bean으로 등록 가능하다.
         *
         * 하지만, 싱글톤을 보장하지 못한다. 즉, 빈으로 등록은 가능하지만 스프링 컨테이너가 관리하는 빈은 아니다.
         *
         * 그러한 결과는 다음과 같이 각각의 다를 주소로 인스턴스가 생성된것을 확인해보면 알수있다.
         *
         * */


        MemberRepository memberRepository = ac.getBean("getMemberRepository", MemberRepository.class);
        MemberRepository memberRepository1 = memberService.getMemberServiceRepo();
        MemberRepository memberRepository2 = orderService.getMemberRepository();


        System.out.println("memberRepository1 : " + memberRepository1);
        System.out.println("memberRepository2 : " + memberRepository2);
        System.out.println("memberRepository : " +memberRepository);
    }
}
