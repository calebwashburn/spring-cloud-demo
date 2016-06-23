package com.cwashburn.domain;

public class Special {
	private String special;
	private String date;
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Special(String special, String date) {
		super();
		this.special = special;
		this.date = date;
	}
}
