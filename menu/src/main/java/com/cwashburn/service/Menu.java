package com.cwashburn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Menu {

	@Value("${menu.special}")
	String special;
	
	public String getSpecial() {
		return special;
	}
}
