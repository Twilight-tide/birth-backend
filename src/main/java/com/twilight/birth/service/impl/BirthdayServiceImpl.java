package com.twilight.birth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.twilight.birth.entity.Birthday;
import com.twilight.birth.mapper.BirthdayMapper;
import com.twilight.birth.service.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthdayServiceImpl implements BirthdayService {

    @Autowired
    private BirthdayMapper birthdayMapper;

    @Override
    public boolean save(Birthday birthday) {
        return birthdayMapper.insert(birthday) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return birthdayMapper.deleteById(id) > 0;
    }

    @Override
    public boolean update(Birthday birthday) {
        return birthdayMapper.updateById(birthday) > 0;
    }

    @Override
    public List<Birthday> getTodayBirthdays(Long userId) {
        return birthdayMapper.selectTodayBirthdays(userId);
    }

    @Override
    public List<Birthday> getBirthdaysByMonth(int month, Long userId) {
        return birthdayMapper.selectBirthdaysByMonth(month, userId);
    }

    @Override
    public List<Birthday> getAll(Long userId) {
        QueryWrapper<Birthday> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return birthdayMapper.selectList(wrapper);
    }
}