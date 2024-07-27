package com.haejun.springpractice.scoper;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * packageName    : com.haejun.springpractice.scoper
 * fileName       : SingleTonProtoTypeSolution1
 * author         : NAHAEJUN
 * date           : 2024-07-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-28        NAHAEJUN              최초생성
 */
public class SingleTonProtoTypeSolution1 {


    @Test
    @DisplayName("SingleTon 에서 ProtoType Scope 주입받을때 해결책1")
    public void protoTypeSolution1(){

        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, ProtoTypeBean.class);
        ClientBean clientBean_A = ac.getBean(ClientBean.class);
        int result_A = clientBean_A.logic();
        System.out.println("clientBean_A : " + result_A);

        ClientBean clientBean_B = ac.getBean(ClientBean.class);
        int result_B = clientBean_B.logic();
        System.out.println("clientBean_B : " +result_B);

    }


    static class ClientBean {
        /**
         *
         * 직접 스프링 컨테이너를 호출해 Bean을 주입받으면 새로 생성이 가능하지만
         * 이렇게되면 스프링의 너무 의존적이게 된다. 단지 ProtoTypeBean 빈만 찾아오면 되는데
         * 스프링컨테이너의 모든 기능까지 호출할 필요까지가 없다는 의미이다.
         *
         * ac.getBean()을 살행해보면 ac.getBean()통해서 항상 새로운 프로토타입 빈이 생성되는 것을 확인할 수 있다.
         * 그런데 이렇게 스프링의 애플리케이션 컨텍스트 전체를 주입받게 되면, 스프링 컨테이너에 종속적인 코드가 되고,
         * 단위 테스트도 어려워진다.
         *
         * 지금 필요한 기능은 지정한 프로토타입 빈을 컨테이너에서 대신 찾아주는 딱!
         * 의존관계를 외부에서 주입(DI) 받는게 아니라 이렇게 직접 필요한 의존관계를 찾는 것을
         * Dependency Lookup (DL) 의존관계 조회(탐색) 이라한다.
         *
         *
         * */
        private final ApplicationContext ac;

        @Autowired
        public ClientBean(ApplicationContext ac) {
            this.ac = ac;
        }

        public int logic() {
            ProtoTypeBean protoTypeBean = ac.getBean(ProtoTypeBean.class);
            protoTypeBean.addCount();
            return protoTypeBean.getCount();
        }

    }

    @Scope("prototype")
    static class ProtoTypeBean {

        private int count;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("ProtoTypeBean init : " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("ProtoTypeBean destroy : " + this);
        }

    }

}
