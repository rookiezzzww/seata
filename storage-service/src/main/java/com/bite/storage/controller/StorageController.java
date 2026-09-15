package com.bite.storage.controller;

import com.bite.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/storage")
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣库存
     * @param code 商品编号
     * @param count 要扣减的数量
     */
    @RequestMapping("/{code}/{count}")
    public ResponseEntity<String> deduct(@PathVariable("code") String code,
                                       @PathVariable("count") Integer count){
        log.info("扣减库存, code:{}, count:{}", code, count);
        storageService.deduct(code, count);
        return ResponseEntity.ok("success");
    }
}
