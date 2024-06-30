package com.haejun.springpractice.exec2.user.config;

import com.haejun.springpractice.exec2.user.repository.UserInfo;
import com.haejun.springpractice.exec2.user.repository.UserInfoInterFace;
import com.haejun.springpractice.exec2.user.service.UserService;
import com.haejun.springpractice.exec2.user.service.impl.UserServiceImpl;

/**
 * packageName    : com.haejun.springpractice.exec2.user.config
 * fileName       : UserConfig
 * author         : NAHAEJUN
 * date           : 2024-06-29
 * description    : 내가바로 Ioc, .DI컨테이너 이다.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-29        NAHAEJUN              최초생성
 */
public class UserConfig {

    public UserService userService(){
        return new UserServiceImpl(userInfo());
    }

    public UserInfoInterFace userInfo(){
        return new UserInfo();
    }

}
