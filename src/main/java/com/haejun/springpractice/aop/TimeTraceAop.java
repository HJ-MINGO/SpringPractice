package com.haejun.springpractice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * packageName    : com.haejun.springpractice.aop
 * fileName       : TimeTraceAop
 * author         : NAHAEJUN
 * date           : 2024-06-16
 * description    :
 * AOP 예시 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-16        NAHAEJUN              최초생성
 */
/* AOP사용시 라이브러리 추가해줘야함 */
/* @Component스캔을 이용해 빈을 등록할수도 있지만 일반적으로 config 파일에 등록해서 사용하는게좋음*/
@Aspect
public class TimeTraceAop {
    // 내가 targeting [적용시킬]클래스를 명명한다.
        
    // @Around만의 문법이 잇지만 지금 예시에 적용한건 모든 com.haejun.springpractice패키지 이하에는 전부 적용한다는 의미
    // @Around("execution(* com.haejun.springpractice..*(..))")
    // service패키지이하에만 적용하겠다하면 다음과 같이 명시
    @Around("execution(* com.haejun.springpractice.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        // joinPoint 에 사용할수 있는 메서드들이 많기 떄문에 여러가지 적용가능하다.
        long startTime = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finsh = System.currentTimeMillis();
            long timeMs = startTime - finsh;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
