package com.bw.oa.service.impl;

import org.springframework.stereotype.Service;

import com.bw.oa.service.TaskDemoServiceI;

@Service
public class TaskDemoServiceImpl implements TaskDemoServiceI {

	@Override
	public void test() {
		System.out.println("定时任务执行...");
	}

}
