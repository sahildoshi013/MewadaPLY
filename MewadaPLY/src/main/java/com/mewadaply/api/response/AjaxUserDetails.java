package com.mewadaply.api.response;

import java.util.List;

public class AjaxUserDetails {
	
	private List<UserDetails> results;
	
	public AjaxUserDetails(List<UserDetails> result) {
		super();
		this.results = result;
	}

	public List<UserDetails> getResults() {
		return results;
	}

	public void setResults(List<UserDetails> results) {
		this.results = results;
	}
	
	
}
