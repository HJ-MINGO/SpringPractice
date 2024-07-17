package com.haejun.springpractice.scoper;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.sql.SQLOutput;

/**
 * packageName    : com.haejun.springpractice.scoper
 * fileName       : SingleTonTest
 * author         : NAHAEJUN
 * date           : 2024-07-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-18        NAHAEJUN              최초생성
 */
public class SingleTonTest {

    @Test
    @DisplayName("Bean스코프 SinglTonTest")
    public void testSingleTon() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingleTonBean.class);
        SingleTonBean sb1 = context.getBean(SingleTonBean.class);
        SingleTonBean sb2 = context.getBean(SingleTonBean.class);
        System.out.println("sb1: " + sb1);
        System.out.println("sb2: " + sb2);

        context.close();
    }
    // 따로 스코프 영역 설정없음 default가 SingleTon 이다.
    @Scope("singleton")
    static class SingleTonBean {

        @PostConstruct
        public void init(){ // 빈생명주기 읜조성 주입후 초기화 시점에 호출
            System.out.println("SingleTonBean init");
        }

        @PreDestroy
        public void destroy(){ // 빈생명주기 종료 직전 호출
            System.out.println("SingleTonBean destroy");
        }



    }
}
