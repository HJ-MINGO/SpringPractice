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
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
   
    private final MemberRepository memberRepository;
    // Appconfig클래스를 이용해 의존성 주입
    // 이렇게 되면 순수하게 memberRepository인터페이스만 의존하게 되므로 DIP 를 지키게 되는것이다.
    // MemberServiceImpl은 memberRepository인터페이스가 뭘로 구현되는지 굳이 알피요없이 그냥
    // memberRepository 인터페이스를 사용하기만하면된다. memberRepository의 구현체는 
    // Appconfig클래스에서 이미 정해줫기 때문에
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // AppCOnfig클래스 적용 (DI)


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberServiceRepo() {
        return memberRepository;
    }
}
