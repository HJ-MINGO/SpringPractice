package com.haejun.springpractice.exec1.member.service;

import com.haejun.springpractice.exec1.member.dto.Member;

/**
 * packageName    : com.haejun.springpractice.exec1.member
 * fileName       : MemberService
 * author         : NAHAEJUN
 * date           : 2024-06-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-20        NAHAEJUN              최초생성
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
