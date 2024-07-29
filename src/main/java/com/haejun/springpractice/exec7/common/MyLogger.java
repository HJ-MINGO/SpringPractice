package com.haejun.springpractice.exec7.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * packageName    : com.haejun.springpractice.exec7.common
 * fileName       : MyLogger
 * author         : NAHAEJUN
 * date           : 2024-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-29        NAHAEJUN              최초생성
 */
@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    /* 해당 MyLogger빈이 생성되는 시점에는 어디서 요청했느니 URL은 알수없다 */
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String messag) {
        System.out.println("[ " + uuid + " ] " + "[ " +requestURL + " ] " +messag);
    }

    @PostConstruct
    public void init() {
        // 그러면 이제 2번째로  @PostConstruct 어노테이션의 의해 init메서드가 실행되고
        // uuid가 만들어진다.
        uuid = UUID.randomUUID().toString();
        System.out.println("[ " + uuid + " ] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[ " + uuid + " ] request scope bean close: " + this);
    }

}
