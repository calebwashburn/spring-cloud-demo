package com.cwashburn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwashburn.domain.RestaurantMenu;
import com.cwashburn.service.Restaurant;

@RestController
public class RestaurantController {

	@Autowired
    private Restaurant restaurant;

    @RequestMapping("/menu")
    public RestaurantMenu menu() {
      return restaurant.getMenu();
    }
}
