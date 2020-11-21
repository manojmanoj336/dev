package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLogin {
	
	@RequestMapping(value ="/getindex", method= RequestMethod.GET)
	public String getIndex()
	{
		
		
		return "index";
	}

}
