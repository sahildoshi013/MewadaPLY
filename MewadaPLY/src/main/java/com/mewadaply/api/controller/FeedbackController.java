package com.mewadaply.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mewadaply.api.model.FeedbackModel;
import com.mewadaply.api.service.FeedbackService;

@Controller
@RequestMapping("/admin/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping
	public String getAllFeedback(ModelMap model) {
		model.put("feedback", feedbackService.getAllFeedback());
		model.put("page", 7);
		return "feedback";
	}
	
}
