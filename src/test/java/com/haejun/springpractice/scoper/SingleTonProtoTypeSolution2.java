package com.haejun.springpractice.scoper;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * packageName    : com.haejun.springpractice.scoper
 * fileName       : SingleTonProtoTypeSolution2
 * author         : NAHAEJUN
 * date           : 2024-07-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-28        NAHAEJUN              최초생성
 */
public class SingleTonProtoTypeSolution2 {
    /**
     *
     * 의존관계를 외부에서 주입(DI) 받는게 아니라 이렇게 직접 필요한 의존관계를 찾는 것을
     * Dependency Lookup (DL) 의존관계 조회(탐색) 이라한다.
     *
     *
     * */

    @Test
    @DisplayName("SingleTon 에서 ProtoType Scope 주입받을때 해결책1")
    public void protoTypeSolution1(){

        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(SingleTonProtoTypeSolution1.ClientBean.class, SingleTonProtoTypeSolution1.ProtoTypeBean.class);
        SingleTonProtoTypeSolution1.ClientBean clientBean_A = ac.getBean(SingleTonProtoTypeSolution1.ClientBean.class);
        int result_A = clientBean_A.logic();
        System.out.println("clientBean_A : " + result_A);

        SingleTonProtoTypeSolution1.ClientBean clientBean_B = ac.getBean(SingleTonProtoTypeSolution1.ClientBean.class);
        int result_B = clientBean_B.logic();
        System.out.println("clientBean_B : " +result_B);

    }


    static class ClientBean {

        /**
         * ObjectProvider 는우리가  ApplicationContext을 통해 직접 빈을 찾는게 아니라
         * (굳이 스프링컨테이너의 전체를 끌고올 필요가없다)
         * 원하는, 해당 빈만 딱 찾아주는 기능만 제공해준다.
         *
         * ObjectFactory, ObjectProvider 지정한 빈을 컨테이너에서 대신 찾아주는 DL 서비스를 제공하는 것이 바로 ObjectProvider
         * 참고로 과거에는 ObjectFactory 가 있었는데, 여기에 편의 기능을 추가해서 ObjectProvider가 만들어졌다.
         *
         * ObjectFactory는 딱 getObject()만 제공하지만
         * ObjectProvider는 ObjectFactory상속받아 다양한 편의기능을 추가하였다 (다형성)
         *
         *
         * 예시만 프로토타입을 들은거 뿐이지 프로토타입에만 해당되는 기능은 아니다.
         * 여기서 말하고자하는 핵심은 스프링 컨테이너를 조회하는데
         * 내가 직접 ApplicationContext을 호출해 스프링컨테이너에서 원하는 빈을 찾는것보다
         * ObjectProvider라는 대리자? 대타? 중간역활? 인 애를 통해서 조회해온다는 의미이다.
         * 참고로 ObjectProvider는 빈으로 등록안해도 기본적으로 스프링컨테이너에서 자동으로 등록해준다.
         *
         *
         * 특징 : 1. ObjectFactory: 기능이 단순, 별도의 라이브러리 필요 없음, 스프링에 의존
         *       2. ObjectProvider: ObjectFactory 상속, 옵션, 스트림 처리등 편의 기능이 많고,
         *          별도의 라이브러리 필요 없음,스프링에 의존(결국 스프링에 의존하는건 같음)
         *
         *
         * */

        private final ObjectProvider<ProtoTypeBean> protoTypeBeanProvider;
//        private final ObjectFactory<ProtoTypeBean> protoTypeBeanProvider;


        @Autowired
        public ClientBean(ObjectProvider<ProtoTypeBean> op) {
            protoTypeBeanProvider = op;
        }

        public int logic() {
            ProtoTypeBean protoTypeBean = protoTypeBeanProvider.getObject();
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
