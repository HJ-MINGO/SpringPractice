package com.haejun.springpractice.exec5;

import com.haejun.springpractice.exec5.config.ScanClass;
import com.haejun.springpractice.exec5.dto.Member;
import com.haejun.springpractice.exec5.service.DiscountPolicy;
import com.haejun.springpractice.exec5.type.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.haejun.springpractice.exec5
 * fileName       : AllBeanTest
 * author         : NAHAEJUN
 * date           : 2024-07-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-14        NAHAEJUN              최초생성
 */
public class AllBeanTest {

    @Test
    @DisplayName("list, Map으로 의존성을 받는다")
    public void findAllBean() {
        //ScanClass클래스는 단순 컴포넌트 스캔을 실행시키기위해 컨테이너의 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScanClass.class,DiscuntPolicy.class);
        DiscuntPolicy dc = ac.getBean(DiscuntPolicy.class);
        Member member = new Member(1L,"userA", Grade.VIP);
        
        //이렇게 전략적으로 상황에 따라 각각 다른 빈을 주입해서 사용가능하다
        int price1 = dc.discount(member,1000,"fixDiscountPlicy");
        System.out.println("price1: " + price1);
        int price2 = dc.discount(member,1000,"rateDiscountPolicy");
        System.out.println("price2: " + price2);
    }

    static class DiscuntPolicy {
        private final Map<String, DiscountPolicy> mapPolicy;
        private final List<DiscountPolicy> listPolicy;

        @Autowired
        public DiscuntPolicy(Map<String, DiscountPolicy> mapPolicy, List<DiscountPolicy> listPolicy) {
            this.mapPolicy = mapPolicy;
            this.listPolicy =listPolicy;
            // 이런식으로 Map으로 매핑 시키면 카멜케이스 형태로 해당 구현체 클래스를 key로 해당 Bean을 value로 담긴다.
            System.out.println("mapPolicy ====> " + mapPolicy);
            // 리스트 형식으로 DiscountPolicy타입의 모든 Bean들이 담긴다.
            System.out.println("listPolicy ====> " + listPolicy);
            /**
             *
             * 이제 이걸이용해 전략패턴으로 내가 서비스 로직에서
             * 어떤경우는 fixDiscountPlicy를 어떤경우에는 rateDiscountPolicy를 주입시켜
             * 전략적으로 필요한 경우에 필요한 Bean을 주입시켜줄수있다.
             *
             * */

        }

        public int discount( Member member , int price,String serviceName){
            DiscountPolicy dc = mapPolicy.get(serviceName);
            return dc.discount(member , price);

        }
    }
}
