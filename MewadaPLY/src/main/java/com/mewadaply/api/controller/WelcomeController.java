package com.mewadaply.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
    @GetMapping("/welcome")
    public String showWelcomePage(ModelMap model){
    	model.put("name", "Sahil");
        return "welcome";
    }

}
