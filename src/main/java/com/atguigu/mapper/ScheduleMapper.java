package com.atguigu.mapper;

import com.atguigu.pojos.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包名:com.atguigu.mapper
 *
 * @author Leevi
 * 日期2023-09-11  09:33
 */
@Mapper
public interface ScheduleMapper {
    List<Schedule> findAll();

    void addSchedule(Schedule schedule);

    void deleteScheduleById(Integer scheduleId);

    void updateSchedule(Schedule schedule);

    List<Schedule> findScheduleListByCompleted(Boolean completed);
}
