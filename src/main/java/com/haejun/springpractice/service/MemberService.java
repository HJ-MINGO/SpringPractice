package com.haejun.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.haejun.springpractice.service
 * fileName       : Service
 * author         : NAHAEJUN
 * date           : 2024-06-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-16        NAHAEJUN              최초생성
 */
@Service
public class MemberService {

    @Autowired
    private BeanMember beanMember;
    // 순환참조 테스트
    public void getMemberService(){
        beanMember.testMethod();
    }
}
