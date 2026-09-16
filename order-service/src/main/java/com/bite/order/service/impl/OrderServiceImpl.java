package com.bite.order.service.impl;

import com.bite.order.api.AccountApi;
import com.bite.order.api.StorageApi;
import com.bite.order.entity.OrderInfo;
import com.bite.order.mapper.OrderMapper;
import com.bite.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private AccountApi accountApi;
    @Autowired
    private StorageApi storageApi;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 创建订单，发起全局事务
     *
     */
    @Override
    @GlobalTransactional
    public Long create(OrderInfo orderInfo) {
        try {
            //插入订单
            orderMapper.insert(orderInfo);
            //扣余额
            accountApi.deduct(orderInfo.getUserId(), orderInfo.getMoney());
            //扣库存
            storageApi.deduct(orderInfo.getCommodityCode(), orderInfo.getCount());

        }catch (Exception e){
            log.error("下单失败, e: ", e);
            throw new RuntimeException("下单失败, e:", e);
        }

        return orderInfo.getId();
    }
}
