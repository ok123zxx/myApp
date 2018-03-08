package com.springboot.myapp.web;

import com.springboot.myapp.exception.BaseException;
import com.springboot.myapp.service.SpringBootService;
import com.springboot.myapp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class SpringBootController {

	@Autowired
	private SpringBootService bootService;

	@Autowired
	private StoreService storeService;

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

//	@RequestMapping(value = "/createStore")
//	public Object createStore(String key,String value){
//		return storeService.createStore(key,value);
//	}

	@RequestMapping(value = "/createByMapper")
	public Object createStoreByMapper(String key,String value){
		return storeService.createByMapper(key, value);
	}

//	@ResponseBody
//	@RequestMapping(value = "/findByMapper")
//	public Object findByMapper(String id){
//	    return storeService.findStore(id);
//    }


}
