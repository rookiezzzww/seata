package com.bite.account.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("account_tbl")
public class AccountInfo {
    @TableId
    private Long id;
    private String userId;
    private Integer money;
}
