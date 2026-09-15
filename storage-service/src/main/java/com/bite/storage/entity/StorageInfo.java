package com.bite.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("storage_tbl")
public class StorageInfo {
    @TableId
    private Long id;
    private String commodityCode;
    private Integer count;
}
