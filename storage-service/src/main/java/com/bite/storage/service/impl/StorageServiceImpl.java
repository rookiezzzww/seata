package com.bite.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bite.storage.entity.StorageInfo;
import com.bite.storage.mapper.StorageMapper;
import com.bite.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void deduct(String commodityCode, Integer count) {
        try {
            UpdateWrapper<StorageInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda().setSql("count = count - "+ count)
                    .eq(StorageInfo::getCommodityCode, commodityCode);
            storageMapper.update(updateWrapper);
        } catch (Exception e) {
            log.error("扣减库存失败, e:", e);
            throw new RuntimeException("扣减库存失败!", e);
        }
    }
}
