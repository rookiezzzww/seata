package com.bite.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "storage-service", path = "/storage")
public interface StorageApi {
    @PutMapping("/{code}/{count}")
    void deduct(@PathVariable("code") String code,
                @PathVariable("count") Integer count);
}
