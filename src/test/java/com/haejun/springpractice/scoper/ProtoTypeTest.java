package com.haejun.springpractice.scoper;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * packageName    : com.haejun.springpractice.scoper
 * fileName       : ProtoTypeTest
 * author         : NAHAEJUN
 * date           : 2024-07-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-18        NAHAEJUN              최초생성
 */
public class ProtoTypeTest {

    @Test
    @DisplayName("ProtoType Scope의 범위 테스트")
    public void testScope() {
        // AnnotationConfigApplicationContext생성할때 매개변수로 직접 클래스를 지정해서 넣어주면
        // 해당 클래스는 @Component 어노테이션 알아서 @Component 가 붙어서 빈으로 등록된다.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        System.out.println("find protoTypeBean1");
        ProtoTypeBean bean1 = context.getBean(ProtoTypeBean.class);
        System.out.println("find protoTypeBean1");
        ProtoTypeBean bean2 = context.getBean(ProtoTypeBean.class);
        System.out.println("bean1 : " + bean1);
        System.out.println("bean2 : " + bean2);
        context.close();
        // prototype범위는 의존성 주입과 초기화가 실행되고 스프링이 따로 관리하지않아 수동으로 close해줘야한다.
//        bean1.destroy();
//        bean2.destroy();

    }

    @Scope("prototype")
    static class ProtoTypeBean{

        @PostConstruct
        public void init(){
            System.out.println("protoTypeBean init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("protoTypeBean destroy");
        }

    }

}
