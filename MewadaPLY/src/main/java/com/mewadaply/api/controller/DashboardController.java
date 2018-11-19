package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.service.DashboardService;
import com.mewadaply.api.utils.Utils;

@Controller
@RequestMapping("/admin")
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	
	@GetMapping("/dashboard")
	public String showPage(HttpSession session,ModelMap model) {
		Boolean res = (Boolean)session.getAttribute(Utils.SESSION_LOGIN);
		if(res==null || !res) {
				return "redirect:/login";
		}
		model.put("page", 1);
		model.put("user_count",dashboardService.getUserCount());
		model.put("redeem_count",dashboardService.getRedeemCount());
		model.put("point_count",dashboardService.getPointCount());
		model.put("redeem_point_count",dashboardService.getRedeemPointCount());
		model.put("history",dashboardService.getRewardHistory());
		
		
		return "dashboard";
	}

}
