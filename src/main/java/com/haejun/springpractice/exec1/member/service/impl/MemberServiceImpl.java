package com.haejun.springpractice.exec1.member.service.impl;

import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.MemoryMemberRepository;
import com.haejun.springpractice.exec1.member.dto.Member;
import com.haejun.springpractice.exec1.member.service.MemberService;

/**
 * packageName    : com.haejun.springpractice.exec1.member
 * fileName       : MemberServiceImpl
 * author         : NAHAEJUN
 * date           : 2024-06-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-20        NAHAEJUN              최초생성
 */
public class MemberServiceImpl implements MemberService {
    // 인터페이스는 해당 인터페이스를 구현한 클래스로 new 생성이 가능하다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
