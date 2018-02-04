package com.springboot.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "store")
public class Store {

	@Id
	private String id;
	
	@Column
	private String kkeeyy;
	
	@Column
	private String val;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKkeeyy() {
		return kkeeyy;
	}

	public void setKkeeyy(String kkeeyy) {
		this.kkeeyy = kkeeyy;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
