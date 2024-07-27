package com.haejun.springpractice.scoper;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * packageName    : com.haejun.springpractice.scoper
 * fileName       : SingleTonProtoTypeTest2
 * author         : NAHAEJUN
 * date           : 2024-07-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-28        NAHAEJUN              최초생성
 */
public class SingleTonProtoTypeExec2 {

    /**
     * ClientBean은 싱글톤 빈이다.
     * AnnotationConfigApplicationContext을 이용해 컴포넌트 스캔할때 ClientBean은 스프링컨테이너의 등록이 되고
     * ClientBean생성자에서 필드주입방식으로 의존성 주입이 선언되어있으므로
     * ClientBean자동적으로 스프링컨테이너에게 protoTypeBean을 내놔 라고 애기해고(스프링컨테이너 내부의 요청)
     * 스프링컨테이너는 요청을 받는 즉시에 ProtoTypeBean을 생성과 동시에 싱글톤빈인 ClientBean에 의존성을 주입해준다.
     * 생성과 주입이 동시에 일어나게 되고 이때 만들어진 ProtoTypeBean의 스코프영역은 "prototype"이기에 생성과 주입이 끝난즉시
     * 스프링컨테이너에서는 버려지게 된다. 그때부터는 ClientBean에서는 버려진 ProtoTypeBean을 가지고 있기때문에
     * 재생성이 아닌 같은 ProtoTypeBean을 사용하게되는것이다. (스프링 컨테이너의 등록되지않은 싱글톤이랑 다를게 뭐임..?)
     * 결론적으로 스프링은 일반적으로 싱글톤 빈들 사용한다. 싱글톤 빈이 프로토타입의 빈을 사용(의존받게)하게 되면 싱글톤 빈자체가
     * 생성시점에만 의존관계를 주입을 받아 스프링컨테이너의 등록이 되므로 프로토타입빈을 의존받은 싱글톤 빈을 계속호출해도
     * 다시 생성해서 스프링컨테이너의 등록되는게 아님으로 프로토타입의 빈도 계속 유지되는 것이다.
     *
     * 우리가 정작 "prototype"을 쓰는 이유가없다~?
     * 왜 그럴거면 걍 싱글톤만 쓰지... 특별한 경우로 사용하고 싶어 쓰는게 프로토타입인데.. 어떻때 사용하는가?
     *
     *참고: 여러 빈에서 같은 프로토타입 빈을 주입 받으면, 주입 받는 시점에 각각 새로운 프로토타입 빈이 생성 된다.
     * 예를 들어서 clientA, clientB가 각각 의존관계 주입을 받으면 각각 다른 인스턴스의 프로토타입 빈을 주입 받는다.
     *  EX)
     *  clientA  prototypeBean@x01 (clientA라는 클래스)
     *  clientB  prototypeBean@x02 (clientB라는 클래스)
     *  물론 사용할 때 마다 새로 생성되는 것은 아니다.
     *
     *
     * */


    @Test
    @DisplayName("싱글톤빈의 프로토타입 빈의 의존성이 주입되었을때")
    public void protoTypeWithSingleTone() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ProtoTypeBean.class,ClientBean.class);
        ClientBean clientA = ac.getBean(ClientBean.class);
        int result_A = clientA.logic();
        System.out.println("clientA result = " + result_A);
        ClientBean clientB = ac.getBean(ClientBean.class);
        int result_B = clientB.logic();
        System.out.println("clientB result = " + result_B);
    }
    // @Scope의 default는 "singleton" 이기 때문에 생략해줘도 된다
    @Scope("singleton")
    static class ClientBean {
        private final ProtoTypeBean protoTypeBean;

        //단일 생성사일떄는 @Autowired 생략가능
        @Autowired
        public ClientBean(ProtoTypeBean protoTypeBean){
            this.protoTypeBean = protoTypeBean;
        }

        public int logic(){
            protoTypeBean.addCount();
            return protoTypeBean.getId();
        }
    }

    @Scope("prototype")
    static class ProtoTypeBean {
        private int id;

        public void addCount(){
            id++;
        }

        public int getId(){
            return id;
        }
        @PostConstruct
        public void init(){
            System.out.println("ProtoTypeBean init " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("protoTypeBean destroy ");
        }
    }
}
