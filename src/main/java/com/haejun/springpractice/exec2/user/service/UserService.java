package com.haejun.springpractice.exec2.user.service;

import com.haejun.springpractice.exec2.user.dto.User;

/**
 * packageName    : com.haejun.springpractice.exec2.user.service
 * fileName       : UserService
 * author         : NAHAEJUN
 * date           : 2024-06-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-29        NAHAEJUN              최초생성
 */
public interface UserService {

    public void save(User user);

    public String getUserName(long userId);
}
