package com.haejun.springpractice.xml;

import com.haejun.springpractice.exec1.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * packageName    : com.haejun.springpractice.xml
 * fileName       : xmlAppContext
 * author         : NAHAEJUN
 * date           : 2024-07-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-03        NAHAEJUN              최초생성
 */
public class xmlAppContext {


    @Test
    void xmlAppContext() {

        ApplicationContext applicationContext = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

    }
}
