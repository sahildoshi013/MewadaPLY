package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mewadaply.api.utils.Utils;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@PostMapping("/login")
	public String checkLoginPage(HttpSession session,ModelMap model, @RequestParam("log_e_mail") String email,@RequestParam("log_password") String password) {
		System.out.println(email + password);
		boolean isLogin = (email.toLowerCase().equals("admin@mewadaply.com") && password.equals("MewadaPly013"));
		
		System.out.println(isLogin);
		
		if (isLogin) {
			session.setAttribute(Utils.SESSION_LOGIN, true);
			return "redirect:/admin/dashboard";
		}
		model.put("message", "*Invalid Email or Password");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
