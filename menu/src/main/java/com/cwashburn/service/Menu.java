package com.cwashburn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class Menu {

	@Value("${menu.special}")
	String special;
	
	public String getSpecial() {
		return special;
	}
}
