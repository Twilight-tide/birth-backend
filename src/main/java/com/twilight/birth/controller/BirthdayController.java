package com.twilight.birth.controller;

import com.twilight.birth.entity.Birthday;
import com.twilight.birth.service.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birthdays")
public class BirthdayController {

    @Autowired
    private BirthdayService birthdayService;

    // 临时固定userId=1（后面加登录后从token取）
    private Long getCurrentUserId() {
        return 1L;
    }

    // 添加生日
    @PostMapping("/add")
    public String add(@RequestBody Birthday birthday) {
        birthday.setUserId(getCurrentUserId());
        boolean success = birthdayService.save(birthday);
        return success ? "添加成功 ✅" : "添加失败 ❌";
    }

    // 删除生日
    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        boolean success = birthdayService.delete(id);
        return success ? "删除成功 ✅" : "删除失败 ❌";
    }

    // 更新生日
    @PostMapping("/update")
    public String update(@RequestBody Birthday birthday) {
        boolean success = birthdayService.update(birthday);
        return success ? "更新成功 ✅" : "更新失败 ❌";
    }

    // 查询今日寿星
    @GetMapping("/today")
    public List<Birthday> today() {
        return birthdayService.getTodayBirthdays(getCurrentUserId());
    }

    // 查询某月生日
    @GetMapping("/month")
    public List<Birthday> month(@RequestParam int month) {
        return birthdayService.getBirthdaysByMonth(month, getCurrentUserId());
    }

    // 查询所有生日
    @GetMapping("/all")
    public List<Birthday> all() {
        return birthdayService.getAll(getCurrentUserId());
    }
}