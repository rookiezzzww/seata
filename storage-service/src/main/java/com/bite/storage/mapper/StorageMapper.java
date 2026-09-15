package com.bite.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bite.storage.entity.StorageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageMapper extends BaseMapper<StorageInfo> {

}
