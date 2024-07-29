package com.haejun.springpractice.exec7.controller;

import com.haejun.springpractice.exec7.common.MyLogger;
import com.haejun.springpractice.exec7.service.LogDemoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * packageName    : com.haejun.springpractice.exec7.controller
 * fileName       : LogDemoController
 * author         : NAHAEJUN
 * date           : 2024-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-29        NAHAEJUN              최초생성
 */
@Controller
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerProvider; // ObjectProvider 사용

    @Autowired
    public LogDemoController(LogDemoService logDemoService,ObjectProvider<MyLogger> myLoggerProvider) {
        this.logDemoService = logDemoService;
        this.myLoggerProvider = myLoggerProvider;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public void logDemo(HttpServletRequest req) throws InterruptedException {
        // 1.http요청이오고 그때서야 myLoggerProvider.getObject()를 통해 처음 mylogger빈이 만들어지게된다.
        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = req.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        Thread.sleep(1000); /* TODO 클라이언트 여러명이 동시 호출시 어떻게되는지 실험하기 위한 장치 */

        myLogger.log("controller test");
        logDemoService.logic("Controller Log Demo");
    }
}
