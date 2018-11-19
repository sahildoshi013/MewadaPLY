package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.service.UserService;
import com.mewadaply.api.utils.Utils;

@Controller
@RequestMapping("/admin/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getAllUser(ModelMap model,HttpSession session) {
		Boolean res = (Boolean)session.getAttribute(Utils.SESSION_LOGIN);
		if(res==null || !res) {
				return "redirect:/login";
		}
		model.put("page", 8);
		model.put("users", userService.getAllUsers());
		return "users";
	}
}
