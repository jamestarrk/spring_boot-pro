package com.atguigu.service.impl;
import com.atguigu.anno.InvokeTime;
import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.service.ScheduleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 包名:com.atguigu.service.impl
 *
 * @author Leevi
 * 日期2023-09-11  10:06
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public PageResult<Schedule> findPage(Integer pageNum, Integer pageSize) {
        //1. 开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2. 执行查询
        List<Schedule> scheduleList = scheduleMapper.findAll();
        //3. 封装分页数据到PageInfo对象中
        PageInfo pageInfo = new PageInfo(scheduleList,10);
        //4. 将PageInfo对象中的数据封装到PageResult对象中
        return new PageResult<>(pageInfo.getList(),pageInfo.getPageSize(),pageInfo.getTotal(),pageInfo.getPageNum());
    }

    @Transactional
    @Override
    public void add(Schedule schedule) {
        scheduleMapper.addSchedule(schedule);
    }

    @InvokeTime
    @Transactional
    @Override
    public void update(Schedule schedule) {
        scheduleMapper.updateSchedule(schedule);
    }

    @InvokeTime
    @Transactional
    @Override
    public void delete(Integer id) {
        scheduleMapper.deleteScheduleById(id);
        int num = 10/0;
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public List<Schedule> findScheduleListByCompleted(Boolean completed) {
        return scheduleMapper.findScheduleListByCompleted(completed);
    }
}
