package com.atguigu.task;

import com.atguigu.pojos.Schedule;
import com.atguigu.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 包名:com.atguigu.task
 *
 * @author Leevi
 * 日期2023-09-11  11:31
 */
@Component
@Slf4j
public class ScheduleTask {
    @Autowired
    private ScheduleService scheduleService;

    @Scheduled(cron = "0 40 11 * * *")
    public void notifyUserToCompleteSchedule(){
        //1. 获取所有未完成的学习计划
        List<Schedule> scheduleList = scheduleService.findScheduleListByCompleted(false);
        //2. 通知用户完成这些学习计划(使用日志模拟)
        log.info("你好，请按时完成你的学习计划:{}",scheduleList);
    }
}
