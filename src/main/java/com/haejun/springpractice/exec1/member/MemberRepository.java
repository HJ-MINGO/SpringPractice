package com.haejun.springpractice.exec1.member;

import com.haejun.springpractice.exec1.member.dto.Member;

/**
 * packageName    : com.haejun.springpractice.exec1.member
 * fileName       : MemberRepository
 * author         : NAHAEJUN
 * date           : 2024-06-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-19        NAHAEJUN              최초생성
 */
public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
