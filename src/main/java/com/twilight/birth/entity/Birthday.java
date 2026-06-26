package com.twilight.birth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
@TableName("birthdays")
public class Birthday {
    @JsonSerialize(using = ToStringSerializer.class)  // 序列化成字符串
    private Long id;
    private Long userId;
    private String name;
    private String birthDate;
    private String relation;

    @TableField(exist = false)
    private String createdAt;
}