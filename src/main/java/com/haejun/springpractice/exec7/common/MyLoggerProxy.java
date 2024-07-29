package com.haejun.springpractice.exec7.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import java.util.UUID;

/**
 * packageName    : com.haejun.springpractice.exec7.common
 * fileName       : MyLoggerProxy
 * author         : NAHAEJUN
 * date           : 2024-07-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-30        NAHAEJUN              최초생성
 */
@Controller
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) /* proxyMode = ScopedProxyMode.TARGET_CLASS는 가짜 프록시를 만든다 */
public class MyLoggerProxy {
    /**
     * @Scope( proxyMode = )
     * proxyMode옵션은 해당 클래스, 또는 인터페스의 가짜 (프록시)를 만들어서 사용하는 방법이다.
     * 클래스 경우에는 선언시  ScopedProxyMode.TARGET_CLASS
     * 인터페이스 경우에는 proxyMode = ScopedProxyMode.INTERFACES
     * 이방식을 사용하게 가짜프록시를 만들어두고 Http request와 상관없이 가짜 프록시 클래스를 다른 빈에 미리 주입해둘수있다.
     *
     * 일단 껍데기 가짜 MyLoggerProxy를 스프링컨테이너의 등록해둔뒤 호출하는 시점에서
     * 진짜를 찾아서 전달해준다.마치 Probider가 동작했던 방식으로 동작한다.
     * */
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String messag) {
        System.out.println("[ " + uuid + " ] " + "[ " +requestURL + " ] " +messag);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[ " + uuid + " ] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[ " + uuid + " ] request scope bean close: " + this);
    }

}

