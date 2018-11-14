package com.mewadaply.api.utils;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	public static String UPLOAD_PATH = "src\\main\\resources\\static\\";
	public static final String UPLOAD_DESIGN_PATH = UPLOAD_PATH + "images\\designs\\";
	
	public static String randomName(MultipartFile file) {
		long unixtime = System.currentTimeMillis() / 1000L;
		int randomNumber = (int)(Math.random() * 1000) + 1;
		
		return unixtime + "_"  + randomNumber + FileUtils.getFileExtension(file);
	}
	


	private static String getFileExtension(MultipartFile file) {
	    String name = file.getOriginalFilename();
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
	}


}
