package com.haejun.springpractice.exec7.service;

import com.haejun.springpractice.exec7.common.MyLogger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.haejun.springpractice.exec7.service
 * fileName       : LogDemoService
 * author         : NAHAEJUN
 * date           : 2024-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-29        NAHAEJUN              최초생성
 */
@Service
public class LogDemoService {

    /**
     * 오류 발생
     * 원인 :
     * 1. main은 run하게되면 스프링컨테이너가 먼저 뜨게 된다.
     * 2. 스테레오 컴포넌트 Service를 통해 LogDemoService는 스프링 컨테이너의 등록이되지만
     * MyLogger는 SCope영역이 request이기 때문에 웹요청이 없으면 스프링컨테이너의 등록조차 되지 않기때문에
     * 오류가 발생하는것이다. request의 생존범위는 고객의 요청이 들어와서 나갈대 까지 이다.
     *
     * 해결방법
     * ObjectProvider를 사용해 지연시키자
     *
     * */


    private final ObjectProvider<MyLogger> myLogger;

    public LogDemoService(ObjectProvider<MyLogger> myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String id) {
        MyLogger myLogger = this.myLogger.getObject();
        myLogger.log("service id = " + id);
    }
}
