package com.haejun.springpractice.exec6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : com.haejun.springpractice.exec6
 * fileName       : NetWorkConnectionTest
 * author         : NAHAEJUN
 * date           : 2024-07-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-15        NAHAEJUN              최초생성
 */
class NetWorkConnectionTest {


    @Test
    @DisplayName("Bean 생명주기 콜백")
    public void getNetWorkConnection() {
        // ApplicationContext클래스에는 따로 close 메소드 가 없고 자식 클래스인
        // ConfigurableApplicationContext클래스에는 close 메서드가 정의되어있다.
        // AnnotationConfigApplicationContext클래스는  ConfigurableApplicationContext클래스의 자식클래스이다.
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(NetWorkConnectionConfig.class);
        NetWorkConnection client = ac.getBean(NetWorkConnection.class); // 빈생성
//        ac.close(); // 빈 close

        // 인터페이스 방식
        NetWorkConnection2 client2 = ac.getBean(NetWorkConnection2.class);
        ac.close();

    }

    @Configuration
    static class NetWorkConnectionConfig {
        @Bean
        public NetWorkConnection getNetWorkConnection() {
            NetWorkConnection netWorkConnection = new NetWorkConnection();
            /**
             * 생성자 부분을 보면 url 정보 없이 connect가 호출되는 것을 확인할 수 있다.
             * 너무 당연한 이야기이지만 객체를 생성하는 단계에는 url이 없고, 객체를 생성한 다음에 외부에서 수정자 주입을 통해서
             *  setUrl()` 이 호출되어야 url이 존재하게 된다
             *
             * */

            // 수정자주입으로 주소 지정
            netWorkConnection.setUrl("https://www.naver.ocm");
            return netWorkConnection;
        }

//        @Bean(destroyMethod = )
        public NetWorkConnection2 getNetWorkConnection2() {
            NetWorkConnection2 nc = new NetWorkConnection2();
            nc.setUrl("https://www.naver.ocm");
            return nc;
        }

    }

}