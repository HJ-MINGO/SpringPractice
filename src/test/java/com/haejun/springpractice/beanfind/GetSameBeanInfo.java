package com.haejun.springpractice.beanfind;

import com.haejun.springpractice.config.AppSpringConfig;
import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * packageName    : com.haejun.springpractice.beanfind
 * fileName       : GetSameBeanInfo
 * author         : NAHAEJUN
 * date           : 2024-07-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-01        NAHAEJUN              최초생성
 */
public class GetSameBeanInfo {
    /*
     * 타입으로 조회시 같은 타입의 스프링 빈이 둘 이상이면 오류가 발생
     * 이때는 빈 이름을 지정해야 한다.
     * ex) ac.getBeansOfType() 을 사용하면 해당 타입의 모든 빈을 조회할 수 있다.
     *
     * */

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(GetSameBeanInfo.SameBeanConfig.class);


    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복오류 발생")
    void findSameBeanInfo() {
        MemberRepository bean = ac.getBean(MemberRepository.class);

    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findSameBeanName() {
        // Bean이름을 지정해주면 된다.
        MemberRepository bean = ac.getBean("memberRepository",MemberRepository.class);

    }

    @Test
    @DisplayName("특정 타입 모두 조회")
    void findSameBeanByType() {
        Map<String,MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + ", value = " + beansOfType.get(key));
        }
        System.out.println(beansOfType);
    }

    /* public  클래스안에 static class스를 작성했다는거는 해당 static class를 선언한 클래스 안에서만 사용한다는 의미이다.  */
    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }

}
