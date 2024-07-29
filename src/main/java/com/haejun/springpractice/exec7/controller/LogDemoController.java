package com.haejun.springpractice.exec7.controller;

import com.haejun.springpractice.exec7.common.MyLoggerProxy;
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
    //    private final MyLogger myLogger;
    private final MyLoggerProxy myLoggerProxy ;

    @Autowired
    public LogDemoController(LogDemoService logDemoService,MyLoggerProxy myLoggerProxy) {
        this.logDemoService = logDemoService;
        this.myLoggerProxy = myLoggerProxy;
    }

    @RequestMapping("log-demo-proxy")
    @ResponseBody
    public void logDemo(HttpServletRequest req) {
        String requestURL = req.getRequestURL().toString();
        myLoggerProxy.setRequestURL(requestURL);

        System.out.println("myLoggerProxy ==> " + myLoggerProxy.getClass());

        myLoggerProxy.log("controller test");
        logDemoService.logic("Controller Log Demo");
    }
}
