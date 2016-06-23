package com.cwashburn.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuSpecial {

	private String special;
	private String date;

    @JsonCreator
    public MenuSpecial(@JsonProperty("special") String special, @JsonProperty("date") String date) {
        this.special = special;
        this.date = date;
    }

	public String getSpecial() {
		return special;
	}

	public String getDate() {
		return date;
	}

    
}
