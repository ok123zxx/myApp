package com.springboot.myapp.service;

import com.springboot.myapp.entity.Store;
import com.springboot.myapp.mapper.StoreMapper;
import com.springboot.myapp.mapper.datasrc1Mapper.DataSrc1StoreMapper;
import com.springboot.myapp.mapper.datasrc2Mapper.DataSrc2StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myapp.dao.StoreDao;

import java.util.UUID;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;//jpa

	@Autowired
	private StoreMapper storeMapper;//mybatis

	@Autowired
	private DataSrc1StoreMapper dataSrc1StoreMapper;//数据源1

	@Autowired
	private DataSrc2StoreMapper dataSrc2StoreMapper;//数据源2

	public Store createStore(String key,String value){
		Store store = new Store();
		store.setId(UUID.randomUUID().toString());
		store.setKeyT(key);
		store.setVal(value);
		storeDao.save(store);
		return store;
	}

	public Store findStore(String id){
        Store result = storeDao.findOne(id);
        return result;
	}

	public Store createByMapper(String key,String value){
		Store store = new Store();
		store.setId(UUID.randomUUID().toString());
		store.setKeyT(key);
		store.setVal(value);
		storeMapper.insert(store);
		return store;
	}

	public Store createByDateSrc1(String key,String value){
		Store store = new Store();
		store.setId(UUID.randomUUID().toString());
		store.setKeyT(key);
		store.setVal(value);
		dataSrc1StoreMapper.insert(store);
		return store;
	}

	public Store createByDateSrc2(String key,String value){
		Store store = new Store();
		store.setId(UUID.randomUUID().toString());
		store.setKeyT(key);
		store.setVal(value);
		dataSrc2StoreMapper.insert(store);
		return store;
	}
}
