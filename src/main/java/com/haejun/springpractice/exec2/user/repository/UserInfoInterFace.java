package com.haejun.springpractice.exec2.user.repository;

import com.haejun.springpractice.exec2.user.dto.User;

/**
 * packageName    : com.haejun.springpractice.exec2.user.repository
 * fileName       : UserInfoInterFace
 * author         : NAHAEJUN
 * date           : 2024-06-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-29        NAHAEJUN              최초생성
 */
public interface UserInfoInterFace {
    public String getUserName(long userId);

    public void setUserInfo(User user);
}
