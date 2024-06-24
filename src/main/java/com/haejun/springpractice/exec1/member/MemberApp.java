package com.haejun.springpractice.exec1.member;

import com.haejun.springpractice.exec1.member.dto.Member;
import com.haejun.springpractice.exec1.member.service.MemberService;
import com.haejun.springpractice.exec1.member.service.impl.MemberServiceImpl;

/**
 * packageName    : com.haejun.springpractice.exec1.member
 * fileName       : MemberApp
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member =  new Member(1L,"해준",Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println(member);
        System.out.println(findmember);
        System.out.println("Member =" + member.getName());
        System.out.println("Find Member =" + findmember.getName());

    }
}
