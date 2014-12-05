package com.vlad.barclaysmobile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

	private String name;
	private String description;

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Category(String name) {
		super();
		this.name = name;
		this.description = "";
	}

	public Category() { // empty category
		super();
		this.name = "";
		this.description = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + "]";
	}

}
