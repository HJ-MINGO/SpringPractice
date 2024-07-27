package com.haejun.springpractice.scoper;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * packageName    : com.haejun.springpractice.scoper
 * fileName       : SingleTonProtoTypeSolution3
 * author         : NAHAEJUN
 * date           : 2024-07-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-28        NAHAEJUN              최초생성
 */
public class SingleTonProtoTypeSolution3 {

    /**
     * 마지막 방법은
     * JSR-330 Provider
     * JSR은 자바 표준을 의미하는것으로 javax.inject.Provider 라는 JSR-330 자바 표준을 사용하는 방법이다.
     * 스프링 부트 3.0은 jakarta.inject.Provider 사용한다.
     * 이 방법을 사용하려면 다음 라이브러리를 gradle에 추가해야 한다.
     * 스프링부트 3.0 미만 javax.inject:javax.inject:1 를 gradle에 추가
     * 스프링부트 3.0 이상 jakarta.inject:jakarta.inject-api:2.0.1 를 gradle에 추가
     *
     * 특징 :
     * 1. get() 메서드 하나로 기능이 매우 단순하다
     * 2. 별도의 라이브러리가 필요하다
     * 3. 자바 표준이므로 스프링이 아닌 다른 컨테이너에서도 사용할 수 있다
     *
     * Provider를 쓰는 시점 [Provider 공식 문서]
     * 1. retrieving multiple instances.
     * 2. lazy or optional retrieval of an instance.
     * 3. breaking circular dependencies.(서킷 순환 디펜던시 - 의존 순환참조 a->b ,b->a 서로가 서로를 의존관계 주입하여 의존관계순환 발생)
     * 4. abstracting scope so you can look up an instance in a smaller scope from an instance in a containing scope.
     *
     *
     *  정리 :
     *  그러면 프로토타입 빈을 언제 사용할까? 매번 사용할 때 마다 의존관계 주입이 완료된 새로운 객체가 필요하면 사용하면 된다.
     *  그런데 실무에서 웹 애플리케이션을 개발해보면, 싱글톤 빈으로 대부분의 문제를 해결할 수 있기 때
     *  문에 프로토타입 빈을 직접적으로 사용하는 일은 매우 드물다.
     *
     *  참고: 프링이 제공하는 메서드에 @Lookup 애노테이션을 사용하는 방법도 있지만, 이전 방법들로 충분하고, 고려해야할 내용도 많아서 생략.
     *
     *  결론:
     *  실무에서 자바 표준인 JSR-330 Provider를 사용할 것인지, 아니면 스프링이 제공하는 ObjectProvider를 사용할 것인지 고민이 될것이다.
     *  ObjectProvider는 DL을 위한 편의 기능을 많이 제공해주고 스프링 외에 별도의 의존관계 추가가 필요 없기 때문에 편리하다.
     *  만약(정말 그럴일은 거의 없겠지만) 코드를 스프링이 아닌 다른컨테이너에서도 사용할 수 있어야 한다면 JSR-330 Provider를 사용해야한다.
     * 스프링을 사용하다 보면 이 기능 뿐만 아니라 다른 기능들도 자바 표준과 스프링이 제공하는 기능이 겹칠때가 많이 있다.
     * 대부분 스프링이 더 다양하고 편리한 기능을 제공해주기 때문에, 특별히 다른 컨테이너를 사용할 일이 없다면,
     * 스프링이 제공하는 기능을 사용하면 된다.
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

        private final Provider<ProtoTypeBean> protoTypeBeanProvider;

        @Autowired
        public ClientBean(Provider<ProtoTypeBean> pro) {
            protoTypeBeanProvider = pro;
        }

        public int logic() {
            ProtoTypeBean protoTypeBean = protoTypeBeanProvider.get();
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
