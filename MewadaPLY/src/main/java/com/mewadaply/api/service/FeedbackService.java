package com.mewadaply.api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mewadaply.api.dao.FeedbackDao;
import com.mewadaply.api.dao.UserDao;
import com.mewadaply.api.model.FeedbackModel;
import com.mewadaply.api.response.FeedbackResponse;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackDao feedbackDao;
	
	@Autowired
	UserDao userDao;
	
	public Iterable<FeedbackModel> getAllFeedback() {
		return feedbackDao.findAll();
	}
}
