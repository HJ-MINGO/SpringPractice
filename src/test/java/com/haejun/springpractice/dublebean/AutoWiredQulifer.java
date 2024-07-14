package com.haejun.springpractice.dublebean;

/**
 * packageName    : com.haejun.springpractice.autowired
 * fileName       : AutoWiredQulifer
 * author         : NAHAEJUN
 * date           : 2024-07-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-15        NAHAEJUN              최초생성
 */
public class AutoWiredQulifer {


    /**
     *
     * 2개이상 타입이 같은 Bean이 존재시, 따로 이름을 다르게 지정하지 않았다면
     * 중복으로 예외가떨어지지만 그중 @Qualifier 를 사용해 서로 사용하는 부분에서
     * 매핑 해준다고 했지만 단점이 존재한다.
     * 보통 @Qualifier 어노테이션은 @Qualifier("커스텀명") 이렇게 String(문자)를
     * 이용해 해당 명으로 매핑한다했지만, 혹시라도 오타라도 적는다면? 자바는 컴파일 과정에서
     * 문자형태는 컴파일시 체크가 되지않늗다. 즉, 컴파일 시점에 오류는 발생하지 않지만
     * 오타로 인해 제대로 매핑이 되지않아 런타임 시점에 오류가 발생한다면?
     * 그걸 방지하고자 커스텀 어노테이션을 이용한다.
     *
     * */



}
