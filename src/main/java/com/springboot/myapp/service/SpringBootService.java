package com.springboot.myapp.service;

import com.springboot.myapp.exception.BaseException;
import org.springframework.stereotype.Service;

@Service
public class SpringBootService {

	public String getName() {
		return "service get name caion";
	}
}
