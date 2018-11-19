package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mewadaply.api.service.RedeemRequestService;
import com.mewadaply.api.utils.Utils;

@Controller
@RequestMapping("/admin")
public class RedeemRequestController {

	@Autowired
	RedeemRequestService redeemRequestService;
	
	
	@GetMapping("/redeem")
	public String showRedeemRequest(ModelMap model,HttpSession session) {
		Boolean res = (Boolean)session.getAttribute(Utils.SESSION_LOGIN);
		if(res==null || !res) {
				return "redirect:/login";
		}
		model.put("page", 2);
		model.put("pending_requests", redeemRequestService.getPedingRequests());
		model.put("requests", redeemRequestService.getRequests());
		return "redeem";
	}
}
