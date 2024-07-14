package com.haejun.springpractice.autowired;

import jakarta.annotation.Nullable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

/**
 * packageName    : com.haejun.springpractice.autowired
 * fileName       : AutoWiredTest
 * author         : NAHAEJUN
 * date           : 2024-07-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-13        NAHAEJUN              최초생성
 */
public class AutoWiredTest {

    /**
     *
     * 어쩌면 당연한 이야기이지만 의존관계 자동 주입은 스프링 컨테이너가 관리하는 스프링 빈이어야 동작한다.
     *
     * 스프링 빈이 아닌 클래스에서 @Autowired 코드를 적용해도 아무 기능도 동작하지 않는다.
     * 주입할 스프링 빈이 없어도 동작해야 할 때가 있다.
     * 그런데 @Autowired 는 옵션 처리를 해주지 않으면  기본적으로 required옵션이 "true"로 설정이 되어있어
     * 자동 주입 대상이 없으면 오류 가 발생한다.
     * 그러한 오류를 발생 시키지 않는 필드주입 방식인 @Autowired의 옵션을 설명하겠다.
     * 
     * */


    @Test
    @DisplayName("AutoWired 옵션")
    public void testAutoWired() {
        /* 스프링 컨테이너의 빈들을 등록하기위해  스프링컨테이너의 TestBean클래스를 등록*/
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    
    /* 스프링 컨테이너의 빈을 등록하기 위한 TestBean 클래스 */
    static class TestBean {

        /**
         * @Autowired옵션을 required = false 해두면 빈를 받을때 설정해두면
         * 예외를 발생시키지 않지만 해당 빈을 사용하게되면 null 예외가 발생한다.
         * 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
         * */
        @Autowired(required = false)
        public void getAutoWiredTestBean1(AutoMember autoMember){
            System.out.println("No bean1 " + autoMember);
        }
        /**
         * @Nullable 어노테이션을 Bean [매개변수 (지역변수)] 를 받을때 설정해두면
         * 해당 빈을 null로 받게된다.
         *
         *
         * 만 사용해도 된다
         * */
        @Autowired
        public void getAutoWiredTestBean2(@Nullable AutoMember autoMember) {
            System.out.println("No bean2 " + autoMember);
        }
        /**
         * Bean [매개변수 (지역변수)]을 받을때 Optional로 한번 감싸게 되면
         * 주입시키려는 빈이 비어있으면 Optional.empty 로 반환된다
         *
         * @Nullable, Optional은 스프링 전반에 걸쳐서 지원된다. 예를 들어서 생성자 자동 주입에서 특정 필드에
         * 만 사용해도 된다
         *
         * */
        @Autowired
        public void getAutoWiredTestBean2(Optional<AutoMember> autoMember){
            System.out.println("No bean3 " + autoMember);
        }
    }
}
