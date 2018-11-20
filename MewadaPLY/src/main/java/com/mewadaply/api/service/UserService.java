package com.mewadaply.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mewadaply.api.dao.UserDao;
import com.mewadaply.api.model.UserModel;
import com.mewadaply.api.utils.Utils;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<UserModel> getAllUsers(){
		return userDao.findAllByuserType(3);
	}

	public List<UserModel> getUserByQuery(String query) {
		return userDao.findByfirstNameContainingAllIgnoreCase(query);
	}

	public UserModel getUserByPhoneNumber(String number) {
		return userDao.findByphoneNo(number);
	}

	public UserModel updateUserData(MultipartFile file, String fname, String lname, String email, String number,
			String address1, String address2, String city) {
		
		fname = Utils.removeQuotes(fname);
		lname = Utils.removeQuotes(lname);
		email = Utils.removeQuotes(email);
		number = Utils.removeQuotes(number);
		address1 = Utils.removeQuotes(address1);
		address2 = Utils.removeQuotes(address2);
		city = Utils.removeQuotes(city);
		
		UserModel user = getUserByPhoneNumber(number);
		String filename = null;
		if(user==null) {
			user = new UserModel();

			//New User Details
			user.setPointEarned(0);
			user.setPointRedeem(0);
			user.setTimeOfCreation(new Date());
			user.setUserType(3);
			user.setUserVerified(true);
			user.setProfilePic("default.png");
		}
		
		
		//Profile Pic
		
		if(file!=null && !file.isEmpty()) {
			 filename = Utils.randomName(file);
			try {
				// Get the file and save it somewhere
				byte[] bytes = file.getBytes();
				Path path = Paths.get(Utils.UPLOAD_USER_PROFILE_PATH + filename);
				Files.write(path, bytes);
				user.setProfilePic(filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
		}
		
		//Insert or Update Data
		user.setPassword("");
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmailId(email);
		user.setAddressLine1(address1);
		user.setAddressLine2(address2);
		user.setCity(city);
		user.setTimeOfUpdation(new Date());
		user.setPhoneNo(number);
		
		userDao.save(user);
		
		return user;
	}

	public UserModel getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId).get();
	}
}
