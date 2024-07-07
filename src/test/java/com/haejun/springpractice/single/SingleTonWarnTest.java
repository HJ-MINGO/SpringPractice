package com.haejun.springpractice.single;

import com.haejun.springpractice.exec3.SingleTonWarn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * packageName    : com.haejun.springpractice.exec3
 * fileName       : SingleTonWarnTest
 * author         : NAHAEJUN
 * date           : 2024-07-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-07        NAHAEJUN              최초생성
 */
class SingleTonWarnTest {
    /**
     * 싱글톤 방식의 주의점
     * 1. 싱글톤 패던이든, 스프링 같은 싱글톤 컨테이너를 사용하든, 객체 인스턴스를 하나만 생성해서
     * 공유하는 싱글톤 방식은 여러클라이언트가 하나의 같은 객체 인스턴스를 공유하기 떄문에 싱글톤
     * 객체는 상태를 유지(stateful) 하게 설계 하면 안된다.
     *
     * 2. 무상태(stateless)로 설계해야 한다.
     *  2-1. 특정 클라이언트에 의존적인 필드가 있으면 안된다.
     *  2-2. 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
     *  2-3. 가급적 읽기만 가능해야 한다. [수정 불가하게 만들어라]
     *  2-4. 필드 대신에 자바에서 공유되지않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
     *
     * 3. 스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생할 수 있다.
     *
     * 4. 스프링 빈은 항상 무상태로 설계해야 한다.
     *
     * */


    @Test
    @DisplayName("SingleTon의 단점")
    public void testSingleTon() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonConfig.class);

        SingleTonWarn st1 = ac.getBean("singleTonWarn", SingleTonWarn.class);
        SingleTonWarn st2 = ac.getBean("singleTonWarn", SingleTonWarn.class);

        st1.order("과자",30000);
        st2.order("과자",50000);

        // 값이 공유되기때문에 st1이 3만원 입금해도
        // st2로 인해 5만원이 된다... 이럴경우 동기화의 문제가 발생
        System.out.println(st1.getPrince());
        // 그렇기 때문에 항상 스프링 빈은 무상태로 설계해야 한다.
    }

    static class SingleTonConfig {

        @Bean
        public SingleTonWarn singleTonWarn() {
            return new SingleTonWarn();
        }
    }
}