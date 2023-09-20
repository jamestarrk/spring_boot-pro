package com.atguigu.controller;

import com.atguigu.groups.AddGroup;
import com.atguigu.groups.UpdateGroup;
import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.result.Result;
import com.atguigu.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 包名:com.atguigu.controller
 *
 * @author Leevi
 * 日期2023-09-11  10:13
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @GetMapping("/{pageSize}/{pageNum}")
    public Result<PageResult<Schedule>> findPage(@PathVariable("pageSize") Integer pageSize,
                                                 @PathVariable("pageNum") Integer pageNum) {
        return Result.ok(scheduleService.findPage(pageNum,pageSize));
    }

    @PostMapping
    public Result add(@Validated(AddGroup.class) @RequestBody Schedule schedule) {
        scheduleService.add(schedule);
        return Result.ok();
    }

    @PutMapping
    public Result update(@Validated(UpdateGroup.class) @RequestBody Schedule schedule) {
        scheduleService.update(schedule);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        scheduleService.delete(id);
        return Result.ok();
    }
}
