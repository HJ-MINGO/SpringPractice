package com.haejun.springpractice.scoper;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * packageName    : com.haejun.springpractice.scoper
 * fileName       : SingleTonWithProtoTypeTest1
 * author         : NAHAEJUN
 * date           : 2024-07-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-27        NAHAEJUN              최초생성
 */
public class SingleTonProtoTypeExec1 {

    @Test
    @DisplayName("싱글톤 빈과 함께 사용시 문제점")
    public void protoTypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class);
        protoTypeBean1.addCount();
        System.out.println("protoTypeBean1 : " + protoTypeBean1.getId());

        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);
        protoTypeBean2.addCount();
        System.out.println("protoTypeBean2 : " + protoTypeBean2.getId());
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
