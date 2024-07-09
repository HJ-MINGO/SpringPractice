package com.haejun.springpractice.scan.filter;

import java.lang.annotation.*;

/**
 * packageName    : com.haejun.springpractice.scan.filter
 * fileName       : MyIncludeComponent
 * author         : NAHAEJUN
 * date           : 2024-07-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-10        NAHAEJUN              최초생성
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent { //MyIncludeComponent이게 붙은거에는 ComponentScan의 스캔되도록하기위함
    
}
