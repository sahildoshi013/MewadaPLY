package com.mewadaply.api.response;

import org.springframework.stereotype.Component;

import com.mewadaply.api.model.FeedbackModel;
import com.mewadaply.api.model.UserModel;

@Component
public class FeedbackResponse {
	
	private FeedbackModel feedbackModel;
	private UserModel userModel;
	
	public FeedbackModel getFeedbackModel() {
		return feedbackModel;
	}
	public void setFeedbackModel(FeedbackModel feedbackModel) {
		this.feedbackModel = feedbackModel;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
}
