package com.mewadaply.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.service.RedeemOfferService;

@Controller
@RequestMapping("/admin/offers")
public class RedeemOfferController {

	@Autowired
	RedeemOfferService redeemOfferService;
	
	@GetMapping
	public String showRedeemOffers(ModelMap model) {
		model.put("page", 3);
		model.put("offers",redeemOfferService.getAllRedeemOffers());
		return "offers";
	}
}

