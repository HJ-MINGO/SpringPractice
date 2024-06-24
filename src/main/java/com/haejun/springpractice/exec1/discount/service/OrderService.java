package com.haejun.springpractice.exec1.discount.service;

import com.haejun.springpractice.exec1.discount.dto.Order;

/**
 * packageName    : com.haejun.springpractice.exec1.discount.service
 * fileName       : OrderrService
 * author         : NAHAEJUN
 * date           : 2024-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-22        NAHAEJUN              최초생성
 */
public interface OrderService {
    Order createOrder(Long memberId, String name,int itemPrice);
}
