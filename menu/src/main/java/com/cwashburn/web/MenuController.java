package com.cwashburn.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwashburn.domain.Special;
import com.cwashburn.service.Menu;

@RestController
public class MenuController {

	@Autowired
    private Menu menu;

    @RequestMapping("/special")
    public Special special() {
      return new Special(menu.getSpecial(), new SimpleDateFormat("YYYY-MM-dd").format(new Date(System.currentTimeMillis())));
    }

}
