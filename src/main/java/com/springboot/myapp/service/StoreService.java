package com.springboot.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myapp.dao.StoreDao;

@Service
public class StoreService {

	@Autowired
	private StoreDao storeDao;
}
