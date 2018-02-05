package com.springboot.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "store")
public class Store {

	@Id
	private String id;
	
	@Column
	private String keyT;
	
	@Column
	private String val;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyT() {
		return keyT;
	}

	public void setKeyT(String keyT) {
		this.keyT = keyT;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
