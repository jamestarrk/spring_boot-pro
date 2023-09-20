package com.atguigu.service;

import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;

import java.util.List;

/**
 * 包名:com.atguigu.service
 *
 * @author Leevi
 * 日期2023-09-11  10:03
 */
public interface ScheduleService {
    PageResult<Schedule> findPage(Integer pageNum,Integer pageSize);

    void add(Schedule schedule);

    void update(Schedule schedule);

    void delete(Integer id);

    List<Schedule> findScheduleListByCompleted(Boolean completed);
}
