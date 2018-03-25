package com.springboot.myapp.web;

import com.springboot.myapp.utils.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

	@RequestMapping(value = "/index")
	public String index(ModelMap map, HttpServletRequest request) {
		CommonUtils.print(request);
		return "translate";
	}
}
