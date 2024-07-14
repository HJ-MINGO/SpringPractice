package com.haejun.springpractice.dublebean;

import com.haejun.springpractice.config.AppSpringConfig;
import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.discount.service.OrderService;
import com.haejun.springpractice.exec1.discount.service.impl.FixDiscountPlicy;
import com.haejun.springpractice.exec1.discount.service.impl.OrderServiceImpl;
import com.haejun.springpractice.exec1.discount.service.impl.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * packageName    : com.haejun.springpractice.dublebean
 * fileName       : DoubbleBeanTest
 * author         : NAHAEJUN
 * date           : 2024-07-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-14        NAHAEJUN              최초생성
 */
public class DoubbleBeanTest {
    
    @Test
    @DisplayName("같은 타입의 빈이 2개 존재할때 어떻게 처리하는가")
    public void getDoubleBeanTest(){
        /**
         *
         * 1. @Autowired 필드 명 매칭
         * 2. @Qualifier  @Qualifier끼리 매칭  빈 이름 매칭
         * 3. @Primary 사용
         *
         * */
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        /**
         * 결론 :
         * @Primary, @Qualifier 활용
         *
         * 코드에서 자주 사용하는 메인 데이터베이스의 커넥션을 획득하는 스프링 빈이 있고, 코드에서 특별한 기능으로 가끔 사
         * 용하는 서브 데이터베이스의 커넥션을 획득하는 스프링 빈이 있다고 생각해보자. 메인 데이터베이스의 커넥션을 획득하
         * 는 스프링 빈은 @Primary 를 적용해서 조회하는 곳에서 @Qualifier 지정 없이 편리하게 조회하고, 서브 데이터베
         * 이스 커넥션 빈을 획득할 때는  @Qualifier 를 지정해서 명시적으로 획득 하는 방식으로 사용하면 코드를 깔끔하게
         * 유지할 수 있다. 물론 이때 메인 데이터베이스의 스프링 빈을 등록할 때 @Qualifier를 지정해주는 것은 상관없다.
         *
         * ※ 우선순위
         *  @Primary는 기본값 처럼 동작하는 것이고, @Qualifier 는 매우 상세하게 동작한다.
         *  이런 경우 어떤 것이 우선권을가져갈까?
         *  스프링은 자동보다는 수동이, 넒은 범위의 선택권 보다는 좁은 범위의 선택권이 우선 순위가 높다.
         *  따라서 여기서도 @Qualifier 가 우선권이 높다
         *
         * */
        ac.getBean(TestConInterFace2.class);

    }
    @Configuration
    static class TestConfig {

        @Bean
        public TestConInterFace2 testConInterFace2() {
            return new TestConInterFace2Impl();
        }

        @Bean
        public TestConInterFace2 testConInterFace3() {
            return new TestConInterFace3Impl();
        }

    }

    static interface TestConInterFace {
        public void test1();
    }

    static interface TestConInterFace2 {
    }

    @Component
    @Qualifier("testConInterFace2Impl")
    static class TestConInterFace2Impl implements TestConInterFace2 {
        /**
         * 2.  @Qualifier  @Qualifier끼리 매칭  빈 이름 매칭
         *  @Qualifier는 추가 구분자를 붙여주는 방법이다. 주입시 추가적인 방법을 제공하는 것으로,
         *  구분할수있는 추가적인 옵션을 하나 제공하는 것이다.
         *  이렇게 내가 넣어줄 의존성에  @Qualifier("testConInterFace2Impl") 를 달아주고
         *  호출하는쪽 매개변수에  @Qualifier옵션을 달아주면 해당 @Qualifier 끼리 매핑해준다.
         *  그렇지만 혹시라도  @Qualifier("testConInterFace2Impl") 지정했는데
         *  "testConInterFace2Impl" 라는 이름의 @Qualifier를 찾지 못하는경우에는
         * @AutoWired의 기본옵션과 마찬가지로 수정자면, 매개변수 , 필드주입이면 필드명
         * "testConInterFace2Impl" 이름을 찾게된다.
         *
         * @Qualifier 실행 순서
         * 1. @Qualifier끼리 매칭
         * 2. 빈 이름 매칭
         * 3. NoSuchBeanDefinitionException 예외 발생
         *
         * */


    }
    @Component
    @Primary
    static class TestConInterFace3Impl implements TestConInterFace2 {
        /**
         * 3.  @Primary
         * 우선순위를 정하는 것으로 해당 컴포넌트가 적용된 구현체가 Bean주입시
         * 다른 구현체를 제외하고 제일 먼저 우선시 된다.
         * TestConInterFace2 타입의 Bean 들 중에서는
         * TestConInterFace3Impl클래스가 제일 우선된다는 뜻이다.
         * 단,대신 이 우선시된다는건 @Qualifier라는 무관하다.
         * @Qualifier를 지정해주면 우선권과 상관없이 @Qualifier가 적용된다
         * 이렇게 우선된다는건 즉 아무런 옵션 설정을 하지 않았을 경우를 말한다.
         * 업무적으로는 메인 DB 가 메인으로 우선시 해야하니 @Primary를 붙여주고
         * 보조 DB를 @Qualifier를 붙여 필요할떄만 @Qualifier를 매칭시켜주기만 하면 된다.
         *
         * */
    }


    @Component
    static class TestConInterFaceImpl implements TestConInterFace {


        /**
         * 1. @Autowired 필드 명 매칭
         * @Autowired의 실행 순서는 1번째가 타입으로 매칭을 시도한다.
         * 본인과 같은 타입이거나, 또는 그타입의 자식들을 다 끌고 온다(해당 인터페이스로 구현한 구현체들 전부)
         * 2번째로는 타입으로 매칭 했을때 2개 이상일 경우는 필드명, 또는 주입시키려는 매개변수의 이름을
         * 매핑시키는 것이다.
         *
         *  @Autowired의 실행 순서는 1번째가 타입으로 매칭을 시도한다.
         *  본인과 같은 타입이거나, 또는 그타입의 자식들을 다 끌고 온다(해당 인터페이스로 구현한 구현체들 전부)
         *  2번째로는 타입으로 매칭 했을때 2개 이상일 경우는 필드명, 또는 주입시키려는 매개변수의 이름을
         *  매핑시키는 것이다.
         *
         * */

        private final TestConInterFace2 testConInterFace2;

//        private final TestConInterFace2 testConInterFace2;

        /* 수정자인 경우는 매개변수를 해당 구현체, 내가 주입하고 싶은 Bean클래스에 이름으로 바꿔주면된다.
        *  필드 주입인 경우는  필드 명을 Bean클래스에 이름으로 바꿔주면된다 */
        @Autowired
        public TestConInterFaceImpl(@Qualifier("testConInterFace2Impl") TestConInterFace2 testConInterFace2 ){
            this.testConInterFace2 = testConInterFace2; /* 수정자 주입일 경우는 매개변수를 수정한다.*/
//            this.testConInterFace2Impl = testConInterFace2Impl; /* 필드주입일 경우느 필드 명을 수정한다. */
        }

        public void test1(){

        };

    }

}
