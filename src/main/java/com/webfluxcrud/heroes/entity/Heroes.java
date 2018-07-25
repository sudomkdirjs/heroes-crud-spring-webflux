package com.webfluxcrud.heroes.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Heroes")
public class Heroes implements Serializable {

	
	@Id
	int id;

	String name;
	String age;
	
	public Heroes() {
	
	}

	public Heroes(String name, String age) {
		
		
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Heroes [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
