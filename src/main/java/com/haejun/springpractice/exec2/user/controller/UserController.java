package com.haejun.springpractice.exec2.user.controller;

import com.haejun.springpractice.exec2.user.config.UserConfig;
import com.haejun.springpractice.exec2.user.dto.User;
import com.haejun.springpractice.exec2.user.service.UserService;
import com.haejun.springpractice.exec2.user.service.impl.UserServiceImpl;

/**
 * packageName    : com.haejun.springpractice.exec2.user.controller
 * fileName       : usercontroller
 * author         : NAHAEJUN
 * date           : 2024-06-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-29        NAHAEJUN              최초생성
 */
public class UserController {

    public static void main(String[] args) {
        User user = new User();
        UserConfig userConfig = new UserConfig();
//        UserService userService = new UserServiceImpl();
        userConfig.userService().save(user);
        userConfig.userService().getUserName(user.getId());

    }
}
