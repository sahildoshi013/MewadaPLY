package com.mewadaply.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class DashboardController {

	@GetMapping("/dashboard")
	public String showPage(ModelMap model) {
		model.put("page", 1);
		return "dashboard";
	}

	@PostMapping("/login")
	public String checkLoginPage(ModelMap model, RedirectAttributes redirectAttrs) {
		boolean isLogin = true;
		if (isLogin) {
			redirectAttrs.addAttribute("page", 1);
			return "redirect:/admin/dashboard/{page}";
		}
		model.put("message", "*Invalid Email or Password");
		return "admin/login";
	}

}
