package com.haejun.springpractice.exec5.anotaion;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * packageName    : com.haejun.springpractice.exec5.anotaion
 * fileName       : CustomAnoTaion
 * author         : NAHAEJUN
 * date           : 2024-07-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-15        NAHAEJUN              최초생성
 */

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("customName")
public class CustomAnoTaion {
 /**
  *
  * 이런식으로 @Qualifier 자체를  커스텀 어노테이션 자체로 등록해놓으면
  * 굳이 @Qualifier어노테이션을 이용해 String으로 이름을 정해 오타로 인한 run타임 오류를
  * 발생시킬필요도없고 바로바로 안전하게 사용할수 있는 장점이있다.
  * 매칭 해주는 부분에 클래스에 @Qualifier 대신 해당 커스텀어노테이션을 붙이고
  * 주입시키려는 매개변수에도 그냥 @Qualifier 을 붙여서 사용한면되다.
  *
  * */
}
