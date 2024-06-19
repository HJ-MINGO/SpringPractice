package com.haejun.springpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.haejun.springpractice.service
 * fileName       : BeanMember
 * author         : NAHAEJUN
 * date           : 2024-06-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-16        NAHAEJUN              최초생성
 */
public class BeanMember {

    @Autowired
    private MemberService memberService;
    // 순환참조 메서드 테스트
    public void testMethod(){
        memberService.getMemberService();
    }
    // 바꿔치기 가능...
    public void setDI( MemberServiceChild  memberServiceChild ) {
        this.memberService = memberServiceChild;
    }
}
