package com.bite.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bite.account.entity.AccountInfo;
import com.bite.account.mapper.AccountMapper;
import com.bite.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void deduct(String userId, Integer money) {

        try {
            UpdateWrapper<AccountInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.lambda().setSql("money = money - "+ money)
                    .eq(AccountInfo::getUserId, userId);
            accountMapper.update(updateWrapper);
        } catch (Exception e) {
            log.error("扣款失败, e:", e);
            throw new RuntimeException("扣款失败, e: ", e);
        }
    }
}
