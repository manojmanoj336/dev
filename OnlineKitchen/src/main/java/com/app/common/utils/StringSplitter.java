package com.app.common.utils;



public class StringSplitter {

	
	public String removeSpecialCharacter(String string)
	{
		if(null !=string)
		return  string.replaceAll("[-+!.]*", "");
		else
		return null;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		String temp = "fdf  dffd fdff,dfffsfdfdf,sfsdf dsfdsfs, dfd  fdf,dfdfdf  ,dffsfs, dfsf";
		//temp=temp.trim();
		
		temp=temp.replaceAll("\\s","");
		String [] tempchar= temp.split(",");
		
		for(String ttempchar : tempchar)
		{
			System.out.println(ttempchar);
		}
		
		
		//SPECIAL CHARACTER REMOVE-------------------
		
		System.out.println("=========================");
		String str = "Hello.+-^Java+ -Programmer,^ ^^-- ^^^ +!";  
		str = str.replaceAll("[-+!.]*", "");
		//str=str.replaceAll("\\W", " ");
		System.out.println("========>" + str);
		
		
		
		
		
	}
	
	
	
	
}
