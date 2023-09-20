package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.atguigu.mapper") // 扫描mapper接口
@EnableScheduling // 允许项目中使用Spring的定时任务功能
@EnableTransactionManagement // 开启事务管理
public class Day12SpringbootCrud01Application {
	public static void main(String[] args) {
		SpringApplication.run(Day12SpringbootCrud01Application.class, args);
	}
}
