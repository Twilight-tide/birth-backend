package com.twilight.birth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.twilight.birth.entity.User;
import com.twilight.birth.mapper.UserMapper;
import com.twilight.birth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean register(String username, String password, String email) {
        if (isUsernameExists(username)) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));  // 加密存储
        user.setEmail(email);
        return userMapper.insert(user) > 0;
    }

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = userMapper.selectOne(wrapper);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public boolean isUsernameExists(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectCount(wrapper) > 0;
    }
}