package com.haejun.springpractice.beandefinition;

import com.haejun.springpractice.config.AppSpringConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * packageName    : com.haejun.springpractice.beandefinition
 * fileName       : FindBeanDefinition
 * author         : NAHAEJUN
 * date           : 2024-07-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-03        NAHAEJUN              최초생성
 */
public class FindBeanDefinition {
    /**
     *  BeanDefinition을 직접 생성해서 스프링 컨테이너에 등록할 수 도 있다. 하지만 실무에서 BeanDefinition을
     * 직접 정의하거나 사용할 일은 거의 없다.  어려우면 그냥 넘어가면 된다^^!
     *  BeanDefinition에 대해서는 너무 깊이있게 이해하기 보다는, 스프링이 다양한 형태의 설정 정보를
     * BeanDefinition으로 추상화해서 사용하는 것 정도만 이해하면 된다.
     * 가끔 스프링 코드나 스프링 관련 오픈 소스의 코드를 볼 때, BeanDefinition 이라는 것이 보일 때가 있다. 이때
     * 이러한 메커니즘을 떠올리면 된다
     *
     * */
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppSpringConfig.class);
    GenericXmlApplicationContext gac = new GenericXmlApplicationContext("appConfig.xml");
    @Test
    @DisplayName("자바를 활용한 BeanDefinition 활용")
    void getBeanDefinitionJava() {
        // 자바를 이용한 config파일에서는 AnnotationConfigApplicationContext클래스에서
        //  AnnotatedBeanDefinitionReader, ClassPathBeanDefinitionScanner
        // 2개의 클래스를 이용해 해당 자바파일의 @Bean 으로 등록된 Bean들을 읽어
        // BeanDfinition 이라는 Bean메타정보를 생성 한다. 그리고 이걸 가지고 ApplicationContext에서
        // BeanDfinition 메타정보를 이용해 스프링컨테이너의 빈을 등록하는것이다.
        String[] displayNames = ac.getBeanDefinitionNames();
        for (String key : displayNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(key);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + key);
                System.out.println("beanDefinition = " + beanDefinition);
                System.out.println("===================================");
                /**
                 * BeanClassName: 생성할 빈의 클래스 명(자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)
                 * factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig
                 *  factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
                 *  Scope: 싱글톤(기본값)을 생성하
                 *  lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연
                 * 처리 하는지 여부
                 * InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
                 * DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
                 * Constructor arguments, Properties: 의존관계 주입에서 사용한다. (자바 설정 처럼 팩토리 역할의 빈을 사용
                 * 하면 없음
                 * */
                /* 위에 해당 메타정보 BeanDefinition을이용해 인스턴스를 생성한다.*/
            }
        }
    }

    @Test
    @DisplayName("xml을 활용한 BeanDefinition 활용")
    void getBeanDefinitionXml() {
        // xml 이용한 config파일에서는 AnnotationConfigApplicationContext클래스에서클래스에서
        //  XmlBeanDefinitionReader 클래스를 이용해 해당 xml파일의 @Bean 으로 등록된 Bean들을 읽어
        // BeanDfinition 이라는 Bean메타정보를 생성 한다. 그리고 이걸 가지고 GenericXmlApplicationContext에서
        // BeanDfinition 메타정보를 이용해 스프링컨테이너의 빈을 등록하는것이다.
        String[] beanDefinitionNames = gac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = gac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName);
                System.out.println("beanDefinition = " + beanDefinition);
                System.out.println("===================================");
            }
        }
        /**
         * BeanClassName: 생성할 빈의 클래스 명(자바 설정 처럼 팩토리 역할의 빈을 사용하면 없음)
         * factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig
         *  factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
         *  Scope: 싱글톤(기본값)을 생성하
         *  lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연
         * 처리 하는지 여부
         * InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
         * DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
         * Constructor arguments, Properties: 의존관계 주입에서 사용한다. (자바 설정 처럼 팩토리 역할의 빈을 사용
         * 하면 없음
         * */

    }
}
