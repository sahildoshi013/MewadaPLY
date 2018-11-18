package com.mewadaply.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mewadaply.api.model.UserModel;
import com.mewadaply.api.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getAllUser(ModelMap model){
		model.put("page", 8);
		model.put("users", userService.getAllUsers());
		return "users";
	}
}