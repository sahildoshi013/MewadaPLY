package com.mewadaply.api.response;

import com.mewadaply.api.model.UserModel;

public class UserDetails {
	
	private int id;
	private String text;
	private UserModel data;
	
	public UserDetails(int id, String text, UserModel data) {
		super();
		this.id = id;
		this.text = text;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public UserModel getData() {
		return data;
	}
	public void setData(UserModel data) {
		this.data = data;
	}
	
	
}
