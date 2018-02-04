package com.springboot.myapp.service;

import com.springboot.myapp.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myapp.dao.StoreDao;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;

	public Store createStore(String key,String value){
		Store store = new Store();
		store.setId("kkid");
		store.setKkeeyy("testKey");
		store.setVal("testValue");
//        Store result = storeDao.findOne("myId");
//        return result;
		storeDao.save(store);
		return store;
	}
}
