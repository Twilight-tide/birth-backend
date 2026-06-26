package com.twilight.birth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twilight.birth.entity.Birthday;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface BirthdayMapper extends BaseMapper<Birthday> {

    @Select("SELECT * FROM birthdays WHERE birth_date = DATE_FORMAT(CURDATE(), '%m-%d') AND user_id = #{userId}")
    List<Birthday> selectTodayBirthdays(Long userId);

    @Select("SELECT * FROM birthdays WHERE LEFT(birth_date, 2) = LPAD(#{month}, 2, '0') AND user_id = #{userId}")
    List<Birthday> selectBirthdaysByMonth(int month, Long userId);
}