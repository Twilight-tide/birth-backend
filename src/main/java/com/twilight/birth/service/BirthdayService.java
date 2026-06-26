package com.twilight.birth.service;

import com.twilight.birth.entity.Birthday;
import java.util.List;

public interface BirthdayService {
    boolean save(Birthday birthday);
    boolean delete(Long id);
    boolean update(Birthday birthday);
    List<Birthday> getTodayBirthdays(Long userId);
    List<Birthday> getBirthdaysByMonth(int month, Long userId);
    List<Birthday> getAll(Long userId);
}