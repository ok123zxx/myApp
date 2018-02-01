package com.springboot.myapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myapp.exception.BaseException;
import com.springboot.myapp.service.SpringBootService;

@RestController
@RequestMapping(value = "/base")
public class SpringBootController {

	@Autowired
	private SpringBootService bootService;
	
	@RequestMapping(value = "/getName")
	public String getName() {
		return bootService.getName();
	}
	
	@RequestMapping(value = "/getException")
	public String getException() {
		if(true) {
			throw new BaseException();
		}
		return "如果你看到这条信息就炸了";
	}
}
