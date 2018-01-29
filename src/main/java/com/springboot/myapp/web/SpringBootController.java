package com.springboot.myapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
