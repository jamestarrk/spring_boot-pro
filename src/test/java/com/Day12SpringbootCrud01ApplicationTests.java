package com;

import com.atguigu.Day12SpringbootCrud01Application;
import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojos.Schedule;
import com.atguigu.result.PageResult;
import com.atguigu.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Day12SpringbootCrud01Application.class)
@Slf4j
class Day12SpringbootCrud01ApplicationTests {
	@Autowired
	private ScheduleMapper scheduleMapper;

	@Autowired
	private ScheduleService scheduleService;
	@Test
	public void testFindAll(){
		//测试查询所有
		log.info(scheduleMapper.findAll().toString());
	}

	@Test
	public void testFindPage(){
		PageResult<Schedule> pageResult = scheduleService.findPage(1, 3);
		log.info("查询到的分页数据是:{}",pageResult);
	}
}
