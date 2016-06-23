package com.cwashburn.domain;

public class RestaurantMenu {

	private String special;
	private String name;
	
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RestaurantMenu(String special, String name) {
		super();
		this.special = special;
		this.name = name;
	}

	
}
