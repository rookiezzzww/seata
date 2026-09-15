package com.bite.account.service;

public interface AccountService {
    /**
     * 从账户中扣款
     */
    void deduct(String userId, Integer money);
}