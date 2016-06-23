package com.cwashburn.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cwashburn.domain.MenuSpecial;
import com.cwashburn.domain.RestaurantMenu;

@Component
public class Restaurant {

	@Autowired
	@LoadBalanced
	private RestTemplate rest;
	
	@Value("${restaurant.name}")
	String name;
	
	public RestaurantMenu getMenu() {
		URI uri = UriComponentsBuilder.fromUriString("http://menu/special").build().toUri();
		MenuSpecial menu = rest.getForObject(uri, MenuSpecial.class);
		return new RestaurantMenu(menu.getSpecial(), name);
	}

}
