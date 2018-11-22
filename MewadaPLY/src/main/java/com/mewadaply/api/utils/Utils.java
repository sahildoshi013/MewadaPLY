package com.mewadaply.api.utils;

import org.springframework.web.multipart.MultipartFile;

public class Utils {
	
	public static String UPLOAD_PATH = "src\\main\\resources\\static\\";
	public static final String UPLOAD_DESIGN_PATH = UPLOAD_PATH + "images\\designs\\";
	public static final String UPLOAD_OFFER_PATH = UPLOAD_PATH + "images\\offers\\";
	public static final Integer PENDING_REQUEST_STATUS = 0;
	public static final Integer ACCECT_REQUEST_STATUS = 1;
	public static final Integer DENY_REQUEST_STATUS = 2;
	public static final String REDEEM_REQUEST_DENY = "Refund Of Redeem Denied";
	public static final int REWARD_POINT_STATUS = 1;
	public static final int REDEEM_POINT_STATUS = 2;
	public static final Integer CUSTOMER_USER_TYPE = 3;
	public static final String SESSION_LOGIN = "login";
	public static final String UPLOAD_USER_PROFILE_PATH = UPLOAD_PATH + "images\\users\\";
	public static final int REDEEM_REQUEST_TYPE = 2;
	public static final String REWARD = "Reward : ";
	
	
	public static String randomName(MultipartFile file) {
		long unixtime = System.currentTimeMillis() / 1000L;
		int randomNumber = (int)(Math.random() * 1000) + 1;
		
		return unixtime + "_"  + randomNumber + Utils.getFileExtension(file);
	}
	


	private static String getFileExtension(MultipartFile file) {
	    String name = file.getOriginalFilename();
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
	}



	public static String removeQuotes(String str) {
		if(str.isEmpty())
			return null;
		return str.substring(1,str.length()-1);
	}


}
