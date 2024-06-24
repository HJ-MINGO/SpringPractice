package com.haejun.springpractice.exec1.discount.service.impl;

import com.haejun.springpractice.exec1.discount.dto.Order;
import com.haejun.springpractice.exec1.discount.service.DiscountPolicy;
import com.haejun.springpractice.exec1.discount.service.OrderService;
import com.haejun.springpractice.exec1.member.MemberRepository;
import com.haejun.springpractice.exec1.member.MemoryMemberRepository;
import com.haejun.springpractice.exec1.member.dto.Member;

/**
 * packageName    : com.haejun.springpractice.exec1.discount.service.impl
 * fileName       : OrderServiceImpl
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    // 1번째 고객 요구사항 고정된 할인금액
//    // private final DiscountPolicy discountPolicy = new FixDiscountPlicy();
//    // 2번째 고객의 변경사항 고정된 금액이 아닌 할인금액으로 바꿔달라 요청
//    // 고객의 요구사항에 의해 고정된 할인금액이 아닌 구매 가격의10%라는 방식으로 변경
//    // 그러면 우리는 구현체만 바꿔주면된다.
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /**
     * 여기서 문제점 발견
     * 일단 solid 원칙을 지키면서 개발한 부분
     * 1. 역할 과 구현을 충실하게 나눔
     * DiscountPolicy 라는 할인 정책에 FixDiscountPlicy(), RateDiscountPolicy()
     * 2가지의 구현체로 나눔
     * 2. 위에 내용처럼 인터페이스를 활용해 다형성도 활요하고, 인터페이스의 구현객체를 분리했다. 
     *
     * 단, 여기서 문제...
     * 겉보기에는 우리가 OCP,DIP같은 객체지향 설계원칙ㅇ늘 충실히 준수했다고 할수있지만
     * 실상은 그렇지 않다. 
     * 1. DIP: 주문서비스 클라이언트 OrderServiceImpl은 DiscountPolicy인터페이스를 의존하면서 DIP를 지킨것
     * 같지만 클래스 의존관계를 분석해보면 ,현재 주문서비스 OrderServiceImpl은 DiscountPolicy인터페이스만 의존하는게
     * 아니라 DiscountPolicy인터페이스를 구현하는 구현체 FixDiscountPlicy(), RateDiscountPolicy()를 의존하고있다.
     * 위에 new를 통해 2개의 구현체를 구현한것만 봐도 이미 DIP를 위배했다.
     * 
     * 2. OCP : 변경하지 않고 확장할수 있다고 했지만, 실상 고객 요구사항에 따라 DiscountPolicy인터페이스의 구현체를
     * 직접 코드로 수정해서 바꿔준것이다.. 변경하지 않는다면서 변경하고있다? 엥?ㅋㅋ
     * 더군다나 이렇게 바꾸는 순간 자체가 내가 이미 추상화에 의존이 아니라 구현체에 의존하기때문에 코드를 바꾸는거라
     * SOLID원칙을 위배하는것이다.
     * 
     * */



    /**
     * 그럼 이제 해당 DiscountPolicy 인터페이스만 의존하도록 설정해 보겠다.
     *
     * */

    // 하지만 에러발생... DiscountPolicy 인터페이스를 구현한 구현체들이 존재하지만...
    // 어떤 구현체인지 알방도가 없으니 NULL 예외 발생... 그래서 어떤구현체가 들어가야하는지... 직접 의존성을 누군가가 주입해줘야하는데
    // 그것이바로 DI - 디텐던시 인젝션 (의존성 주입)
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
