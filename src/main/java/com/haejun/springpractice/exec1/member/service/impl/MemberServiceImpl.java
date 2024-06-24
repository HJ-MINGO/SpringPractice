package com.haejun.springpractice.exec1.member;

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
public class MemberServiceImpl implements  MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {

    }

    @Override
    public Member findMember(Long memberId) {
        return null;
    }
}
