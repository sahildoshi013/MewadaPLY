package com.mewadaply.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mewadaply.api.dao.UserDao;
import com.mewadaply.api.model.UserModel;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<UserModel> getAllUsers(){
		return userDao.findAllByuserType(3);
	}
}
