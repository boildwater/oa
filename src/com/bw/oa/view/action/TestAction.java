package com.bw.oa.view.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bw.oa.service.impl.TestService;
import com.opensymphony.xwork2.ActionSupport;


//加上注解，交给spring进行管理.

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {
	@Resource
	private TestService  testService;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------> action execute");
		testService.saveTwoUsers();
		return "success";
	}
	
}
