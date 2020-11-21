package com.app.resp;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RespData {

	List<String> shayaries;

	public List getShayaries() {
		return shayaries;
	}

	public void setShayaries(List<String> shayaries) {
		this.shayaries = shayaries;
	}
	
	
}
