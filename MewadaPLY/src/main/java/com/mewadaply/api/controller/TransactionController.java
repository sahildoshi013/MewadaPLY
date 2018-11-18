package com.mewadaply.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.service.TransactionService;

@Controller
@RequestMapping("/admin/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@GetMapping
	public String showAllTransaction(ModelMap model) {
		model.put("page", 6);
		model.put("transactions", transactionService.getAllTransactions());
		return "transaction";
	}
}
