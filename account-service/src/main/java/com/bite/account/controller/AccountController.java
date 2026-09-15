package com.bite.account.controller;

import com.bite.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/{userId}/{money}")
    public ResponseEntity<String> deduct(@PathVariable("userId") String userId,
                                       @PathVariable("money") Integer money){
        log.info("对账号进行扣款, userId:{}, money:{}", userId, money);
        accountService.deduct(userId, money);
        return ResponseEntity.ok("success");
    }
}
