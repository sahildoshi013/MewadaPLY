package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.service.TransactionService;
import com.mewadaply.api.utils.Utils;

@Controller
@RequestMapping("/admin/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@GetMapping
	public String showAllTransaction(ModelMap model,HttpSession session) {
		Boolean res = (Boolean)session.getAttribute(Utils.SESSION_LOGIN);
		if(res==null || !res) {
				return "redirect:/login";
		}
		model.put("page", 6);
		model.put("transactions", transactionService.getAllTransactions());
		return "transaction";
	}
}
