package com.haejun.springpractice.exec1.member;

import com.haejun.springpractice.exec1.member.dto.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.haejun.springpractice.exec1.member
 * fileName       : MemoryMemberRepository
 * author         : NAHAEJUN
 * date           : 2024-06-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-20        NAHAEJUN              최초생성
 */
public class MemoryMemberRepository implements MemberRepository{
    //동시성 이슈가 있어 hasMap을 지양
    // 그래서 실무에서는 Concurrent HashMap을 사용한다.
    private  static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
