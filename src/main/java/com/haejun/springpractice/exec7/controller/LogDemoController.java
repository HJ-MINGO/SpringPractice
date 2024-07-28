package com.haejun.springpractice.exec7.controller;

import com.haejun.springpractice.exec7.common.MyLogger;
import com.haejun.springpractice.exec7.service.LogDemoService;
import jakarta.servlet.http.HttpServletRequest;
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
    private final MyLogger myLogger;

    @Autowired
    public LogDemoController(LogDemoService logDemoService,MyLogger myLogger) {
        this.logDemoService = logDemoService;
        this.myLogger = myLogger;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest req) {
        String requestURL = req.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic();
    }
}
