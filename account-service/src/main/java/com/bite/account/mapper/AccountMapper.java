package com.bite.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bite.account.entity.AccountInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<AccountInfo> {
}
