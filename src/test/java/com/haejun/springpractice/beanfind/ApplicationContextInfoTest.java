package com.haejun.springpractice.beanfind;

import com.haejun.springpractice.config.AppSpringConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : com.haejun.springpractice.beanfind
 * fileName       : ApplicationContextInfoTest
 * author         : NAHAEJUN
 * date           : 2024-07-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-01        NAHAEJUN              최초생성
 */
public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppSpringConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
        // getBeanDefinitionNames()을 통해 스프링에 등록된 모든 빈이름을 조회한다.
        // getBean() : 빈 이름으로 빈객체 (인스턴스)르 조회한다.
        String [] beanDefindNames = context.getBeanDefinitionNames();
        for (String beanDefindName : beanDefindNames) {
            Object bean = context.getBean(beanDefindName);
            System.out.println("name = " + beanDefindName + " object = " + bean);
        }
    }
    @Test
    @DisplayName("모든 빈 출력")
    void findApplicationBean(){
            String [] beanDefindNames = context.getBeanDefinitionNames();
        for (String beanDefindName : beanDefindNames) {
            // context.getBeanDefinition() -> Bean에대한 정보를 가지고있다. [bean 하나하나의 메타데이터 정보]
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefindName);
            /*
            *
            * beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION
            * 은 findAllBean() 메서드처럼 스프링 자체내에서 스프링 컨테이너가 실행될떄 기본적으로 담아낸 Bean이 아닌
            * 내가 직접 개발했거나 외부라이브러리르 사용해서 만든 Bean일경우에만 ㄱ가능하다.
            *
            * Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            * Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            * 
            * */
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = context.getBean(beanDefindName);
                System.out.println("name = " + beanDefindName + " object = " + bean);
            }
        }
    }
}
