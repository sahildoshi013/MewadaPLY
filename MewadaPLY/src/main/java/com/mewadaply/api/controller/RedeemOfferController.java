package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.service.RedeemOfferService;
import com.mewadaply.api.utils.Utils;

@Controller
@RequestMapping("/admin/offers")
public class RedeemOfferController {

	@Autowired
	RedeemOfferService redeemOfferService;
	
	@GetMapping
	public String showRedeemOffers(ModelMap model,HttpSession session) {
		Boolean res = (Boolean)session.getAttribute(Utils.SESSION_LOGIN);
		if(res==null || !res) {
				return "redirect:/login";
		}
		model.put("page", 3);
		model.put("offers",redeemOfferService.getAllRedeemOffers());
		return "offers";
	}
}

