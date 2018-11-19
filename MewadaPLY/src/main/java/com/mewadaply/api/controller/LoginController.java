package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mewadaply.api.utils.Utils;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage(ModelMap model) {
		return "admin/login";
	}

	@PostMapping("/login")
	public String checkLoginPage(HttpSession session,ModelMap model, RedirectAttributes redirectAttrs) {
		boolean isLogin = true;
		if (isLogin) {
			session.setAttribute(Utils.SESSION_LOGIN, true);
			return "redirect:/admin/dashboard";
		}
		model.put("message", "*Invalid Email or Password");
		return "admin/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "admin/login";
	}

}
