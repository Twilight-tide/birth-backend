package com.twilight.birth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twilight.birth.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // BaseMapper 已经提供了 save、findById、findAll 等基础方法
}