package com.cwashburn.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Restaurant.class);

	@Autowired
	@LoadBalanced
	private RestTemplate rest;
	
	@Value("${restaurant.name}")
	String name;
	
	public RestaurantMenu getMenu() {
		//if downstream service uses direct use http vs using https if route registration method for url
		
		URI uri = UriComponentsBuilder.fromUriString("http://menu/special").build().toUri();
		LOGGER.info(String.format("Invoking service on url: %s", uri.toString()));
		MenuSpecial menu = rest.getForObject(uri, MenuSpecial.class);
		return new RestaurantMenu(menu.getSpecial(), name);
	}

}
