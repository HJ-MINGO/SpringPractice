package com.haejun.springpractice.scan.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * packageName    : com.haejun.springpractice.scan.filter
 * fileName       : ComponentFilterTest
 * author         : NAHAEJUN
 * date           : 2024-07-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-10        NAHAEJUN              최초생성
 */
public class ComponentFilterTest {

    @Test
    @DisplayName("컴포넌트스캔 테스트")
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        ac.getBean("beanA", BeanA.class);
        ac.getBean("beanB", BeanB.class);
    }
    @Configuration
    @ComponentScan(
            /**
             *
             *   @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = MyIncludeComponent.class)에서
             *   type 옵션에 type = FilterType.ANNOTATION 의 종류를 알아보겠다.
             *
             * 1. ANNOTATION: 기본값, 애노테이션을 인식해서 동작한다.
             *  ex) org.example.SomeAnnotation
             *
             * 2. ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인식해서 동작한다.
             *  ex) org.example.SomeClass
             *
             * 3. ASPECTJ: AspectJ 패턴 사용
             * ex) org.example..*Service+
             *
             * 4. REGEX: 정규 표현식
             * ex) org\.example\.Default.*
             *
             * 5. CUSTOM: TypeFilter 이라는 인터페이스를 구현해서 처리
             * ex) org.example.MyTypeFilter
             *
             * */


            /* includeFilters : 컴포넌트 스캔 대상을 추가로 지정한다.  */
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = MyIncludeComponent.class),
            /* excludeFilters : 컴포넌트 스캔에서 제외할 대상을 지정한다.  */
            excludeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = MyExcludeComponent.class),
                    /* BeanA 도 제외시킬때 사용 */
//                    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = BeanA.class)
            }
    )
    static class ComponentFilterAppConfig {

    }
}
