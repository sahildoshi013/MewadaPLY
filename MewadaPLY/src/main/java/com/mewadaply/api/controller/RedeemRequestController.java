package com.mewadaply.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mewadaply.api.service.RedeemRequestService;

@Controller
@RequestMapping("/admin")
public class RedeemRequestController {

	@Autowired
	RedeemRequestService redeemRequestService;
	
	
	@GetMapping("/redeem")
	public String showRedeemRequest(ModelMap model) {
		model.put("page", 2);
		model.put("pending_requests", redeemRequestService.getPedingRequests());
		model.put("requests", redeemRequestService.getRequests());
		return "redeem";
	}
}
