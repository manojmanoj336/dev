package com.app.resp;

import org.springframework.stereotype.Component;

@Component
public class GenericResponse {

	private int statusCode;
	private String statusDesc;
	private RespData respDap;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public RespData getRespDap() {
		return respDap;
	}
	public void setRespDap(RespData respDap) {
		this.respDap = respDap;
	}
	
	
	
}
