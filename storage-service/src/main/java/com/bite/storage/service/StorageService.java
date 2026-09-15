package com.bite.storage.service;

public interface StorageService {
    /**
     * 扣减库存
     */
    void deduct(String commodityCode, Integer count);
}
