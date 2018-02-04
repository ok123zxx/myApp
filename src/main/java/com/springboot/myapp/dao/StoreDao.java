package com.springboot.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.myapp.entity.Store;

public interface StoreDao extends JpaRepository<Store, String>{
	
	

}
