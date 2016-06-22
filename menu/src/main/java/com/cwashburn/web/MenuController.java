package com.cwashburn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwashburn.service.Menu;

@RestController
public class MenuController {

	@Autowired
    private Menu menu;

    @RequestMapping("/special")
    public String special() {
      return menu.getSpecial();
    }

}
