package com.bite.order.service;

import com.bite.order.entity.OrderInfo;

public interface OrderService {
    /**
     * 创建订单
     */
    Long create(OrderInfo orderInfo);
}
