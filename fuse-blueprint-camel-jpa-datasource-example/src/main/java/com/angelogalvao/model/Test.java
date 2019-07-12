package com.angelogalvao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {

	@Id
	private Long id;
	private String value1;
	private String value2;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	@Override
	public String toString() {
		return "Test[id="+id+",value1="+value1+",value2="+value2+"]";
	}
}
