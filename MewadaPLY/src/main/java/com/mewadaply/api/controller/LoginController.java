package com.mewadaply.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage(ModelMap model) {
		return "admin/login";
	}

	@PostMapping("/login")
	public String checkLoginPage(ModelMap model, RedirectAttributes redirectAttrs) {
		boolean isLogin = true;
		if (isLogin) {
			return "redirect:/admin/dashboard";
		}
		model.put("message", "*Invalid Email or Password");
		return "admin/login";
	}

}
