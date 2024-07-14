package com.haejun.springpractice.exec4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * packageName    : com.haejun.springpractice.exec4.config
 * fileName       : AutoCofig
 * author         : NAHAEJUN
 * date           : 2024-07-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-09        NAHAEJUN              최초생성
 */
@Configuration
@ComponentScan(
//        ComponentScan스캔을 탐색할수 있는 시작 패키지 위치를 지정가능
//        basePackages = "com.haejun.springpractice.exec4.config"
        // 해당 클래스가 시작되는 패키지를 기본으로 ComponentScan스캔을 탐색
//            basePackageClasses = AutoCofig.class,
        // 아무것도 지정하지 않을시 기본적으로 @ComponentScan을 실행시킨 클래스의 패키지를 기본 default로 스캔 시작한다.
        // 예제를위해 Configuration어노테이션붙은 클래스는 자동 스프링빈 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
/**
 * 그래서 일반적으로 스프링부트 프로젝트 생성시 SprinApplication.class가 기본 클래스로 깔려가는게
 * @SpringBootApplication 어노테이션에 @ComponentScan이 포함되어있고 그래서
 * 기본 default로 SprinApplication.class 의 패키지로 스캔을 시작하는 기본베이스로 잡히는 것이다.
 * 그래서 SprinApplication.class가 생성ㄷ괴는 위치가 패키지 최상위 메인 위치이다.
 *
 *  그리고 스테레오 컴포넌트들에 어노테이션의 기능을 할수있게 해주는건 자바가 아닌 스프링의 역할이며
 *  커스텀으로 어노테이션도 제작 가능하다.
 * 컴포넌트 스캔의 용도 뿐만 아니라 다음 애노테이션이 있으면 스프링은 부가 기능을 수행한다.
 *  @Controller : 스프링 MVC 컨트롤러로 인식
 *  @Repository : 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 추상화된 예외로 변환해준다.
 *  특정 DB의 예외들은 다다르다. 근데 그걸 바뀐 DB의 관련된 예외를 맞게끔 예외들을 바꿔준다.
 *  @Configuration : 앞서 보았듯이 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 한다.
 *  @Service :특별한 처리를 하지 않는다. 대신 개발자들이 핵심 비즈니스 로직이 여기에 있겠구나 라고 비즈니스
 *  계층을 인식하는데 도움이 된다.
 *
 * 참고: useDefaultFilters  옵션은 기본으로 켜져있는데, 이 옵션을 끄면 기본 스캔 대상들이 제외된다. 그냥
 * 이런 옵션이 있구나 정도 알고 넘어가자
 * */
public class AutoCofig {

}
