package com.mewadaply.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.service.FeedbackService;
import com.mewadaply.api.utils.Utils;

@Controller
@RequestMapping("/admin/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping
	public String getAllFeedback(HttpSession session,ModelMap model) {
		Boolean res = (Boolean)session.getAttribute(Utils.SESSION_LOGIN);
		if(res==null || !res) {
				return "redirect:/login";
		}
		model.put("feedback", feedbackService.getAllFeedback());
		model.put("page", 7);
		return "feedback";
	}
	
}
