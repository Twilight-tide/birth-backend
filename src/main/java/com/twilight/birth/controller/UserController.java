package com.twilight.birth.controller;

import com.twilight.birth.entity.User;
import com.twilight.birth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        String email = params.get("email");

        boolean success = userService.register(username, password, email);
        return success ? "注册成功 ✅" : "用户名已存在 ❌";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");

        User user = userService.login(username, password);
        return user != null ? "登录成功 ✅" : "用户名或密码错误 ❌";
    }

    // 方便浏览器测试的GET接口（临时用）
    @GetMapping("/register-test")
    public String registerTest(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam(required = false, defaultValue = "") String email) {
        boolean success = userService.register(username, password, email);
        return success ? "注册成功 ✅" : "用户名已存在 ❌";
    }

    // 方便浏览器测试的GET登录接口
    @GetMapping("/login-test")
    public String loginTest(
            @RequestParam String username,
            @RequestParam String password) {
        User user = userService.login(username, password);
        return user != null ? "登录成功 ✅" : "用户名或密码错误 ❌";
    }
}