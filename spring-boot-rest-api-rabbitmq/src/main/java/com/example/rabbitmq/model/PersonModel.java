package com.example.rabbitmq.model;

import java.io.Serializable;

public class PersonModel implements Serializable {

	public PersonModel(Long id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	private Long Id;
	
	private String name;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
