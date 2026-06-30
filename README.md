# 生日管家 - 后端 API

基于 Spring Boot + MyBatis-Plus + MySQL 构建的生日提醒系统后端，提供用户认证、生日数据管理等 RESTful API。

## 技术栈

- Spring Boot 3.x
- MyBatis-Plus
- MySQL
- JWT (jjwt)
- BCrypt 密码加密
- Maven

## 快速开始

### 1. 创建数据库

执行 birthday_db.sql（见下方或自行创建）：

CREATE DATABASE birthday_db DEFAULT CHARSET utf8mb4;

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    created_at DATETIME DEFAULT NOW()
);

CREATE TABLE birthdays (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    relation VARCHAR(20),
    created_at DATETIME DEFAULT NOW()
);

### 2. 修改数据库配置

编辑 src/main/resources/application.yml：

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/birthday_db
    username: root
    password: 你的数据库密码

### 3. 启动项目

mvn spring-boot:run

默认端口：8080

## API 接口

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | /api/auth/register | 用户注册 |
| POST | /api/auth/login | 用户登录（返回JWT Token） |
| GET | /api/birthdays/today | 获取今日寿星列表（需登录） |
| POST | /api/birthdays | 新增生日记录（需登录） |

## 项目状态

✅ 用户注册/登录（JWT认证）  
✅ 生日增删改查（按用户隔离）  
✅ 今日寿星查询接口

## 相关仓库

前端：https://github.com/Twilight-tide/birthday-frontend
