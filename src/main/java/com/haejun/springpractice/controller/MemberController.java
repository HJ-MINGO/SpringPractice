package com.haejun.springpractice.controller;

import com.haejun.springpractice.service.BeanMember;
import com.haejun.springpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * packageName    : com.haejun.springpractice.controller
 * fileName       : MemberController
 * author         : NAHAEJUN
 * date           : 2024-06-16
 * description    :
 *
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-16        NAHAEJUN              최초생성
 */
//@Controller
public class MemberController {
//    /**
//     * 일반적으로 컨트롤러라는 @Controller를 등록하는 순간 빈으로 등록되 스프링이 빌드될때
//     * 스프링컨테이너의 등록되어 해당 컨트롤러를 직접 컨트롤 해준다.
//     *
//     *
//     */
//
//     /* 일반적으로는 객체를 생성할때 new를 사용해서 생성한다. 하지만
//        해당 클래스를 다른 컨트롤러나 다른곳에서 이용할때는 무조건 new로 생성해서 사용하다보니
//        메모리 낭비에.. 똑같은 기능을 사용하기 위해 굳이 여러개를 만들필요도 없어
//        이제 그걸 스프링의 위임하여 빈으로 등록만 시켜서 객체를 알아서 생성시키게 해서
//        동작하게 만드는 시스템이다.
//      */
////     private final MemberService = new MemberService()
//            // 이게 바로 디펜던시인젝션이다 . 의존성 주입
//    private final MemberService memberService;
//
//    //Configuration을 이용한 디펜던시 인젝션
//    private final BeanMember beanMember;
//
//    // 이렇게 생성자로 만들어두면 해당 컨트롤러가 컨테이너의 등록이되면서
//    // 생성자를 만들게되는데 이생성자를 만들때 이미 @Service빈으로 등록한
//    // 빈도 같이 동시에 올라가므로 그 컨테이너에서 관리하는 빈을 직접여기다 주입해서
//    // this.memberService 에 넣어주는것이다.
//    // 그래서 결국 우리는 new로 생성하지 않아도 스프링이 올라감과 동시에 빈으로 등록된
//    // memberService객체를 사용할수있게되는것이다.
//    @Autowired
//    public MemberController(MemberService memberService
//    , BeanMember beanMember) {
//        this.memberService = memberService;
//        this.beanMember = beanMember;
//    }
//
////    public MemberController(MemberService memberService) {
////        this.memberService = memberService;
////    }



}
