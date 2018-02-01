package com.springboot.myapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/index")
	public String index(ModelMap map) {
		map.put("name", "caion");
		
		System.out.println("in index page");
		return "index";
	}
}
