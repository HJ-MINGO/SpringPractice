package com.haejun.springpractice.scan.duble;

import com.haejun.springpractice.exec1.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * packageName    : com.haejun.springpractice.scan.duble
 * fileName       : ScanDoubleWarn
 * author         : NAHAEJUN
 * date           : 2024-07-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-10        NAHAEJUN              최초생성
 */
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class ScanDoubleWarn {

    /**
     * 자동 빈등록 vs 수동 빈등록
     *
     * 자동 빈등록과 수동 빈등록의 이름이 똑같을때 스프링을 시작하게되면
     * Overriding bean definition
     * 수동으로 등록한 빈이 우선권을 갖는다
     *
     * 일반적으로 내가 지정한 위치에서 컴포넌트 스캔을 임의로 동작시킬때는 오버라이드 되서 에러가 발생하지 않지만
     * SpringApplication 클래스에서 직접 스프링부트를 올릴경우 예외를 발생시킨다 (충돌을 감지하고 예외를 뱉어냄)
     * [ConflictingBeanDefinitionException 발생]
     * 그래서 그러한 예외를 발생시키지 않도록 propertis파일에
     * pring.main.allow-bean-definition-overriding=true 해당 옵션을 주면된다.
     * 부트는 기본적으로 false로 설정되어있다.
     * */

    @Bean(name = "memoryMemberRepository") // MemoryMemberRepository와 이름이 같음
    public MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }
}
