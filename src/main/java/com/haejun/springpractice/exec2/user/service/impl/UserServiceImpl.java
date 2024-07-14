package com.haejun.springpractice.exec2.user.service.impl;

import com.haejun.springpractice.exec2.user.dto.User;
import com.haejun.springpractice.exec2.user.repository.UserInfo;
import com.haejun.springpractice.exec2.user.repository.UserInfoInterFace;
import com.haejun.springpractice.exec2.user.service.UserService;

/**
 * packageName    : com.haejun.springpractice.exec2.user.service.impl
 * fileName       : UserServiceImpl
 * author         : NAHAEJUN
 * date           : 2024-06-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-29        NAHAEJUN              최초생성
 */
public class UserServiceImpl implements UserService {

//    private UserInfoInterFace userRepo = new UserInfo();
    private final UserInfoInterFace userRepo;

    public UserServiceImpl(UserInfoInterFace userInfo) {
        this.userRepo = userInfo;

    }

    @Override
    public String getUserName(long userId) {
        return userRepo.getUserName(userId);
    }

    @Override
    public void save(User user) {
        userRepo.setUserInfo(user);
    }
}
