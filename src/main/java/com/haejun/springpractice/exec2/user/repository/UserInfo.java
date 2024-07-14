package com.haejun.springpractice.exec2.user.repository;

import com.haejun.springpractice.exec2.user.dto.User;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.haejun.springpractice.exec2.user.repository
 * fileName       : userInfo
 * author         : NAHAEJUN
 * date           : 2024-06-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-29        NAHAEJUN              최초생성
 */
public class UserInfo implements UserInfoInterFace{

    private  static Map<Long, User> store = new HashMap<>();

    @Override
    public void setUserInfo(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public String getUserName(long userId) {
        return store.get(userId).getName();
    }
}
