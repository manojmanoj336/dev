package com.app.common.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestingDemo {

	
	public static void main(String[] args) {
		
		long nano = System.nanoTime();
		
		
		System.out.println(new Date(nano));
		
		SimpleDateFormat forr = new SimpleDateFormat("ddMMyyyHHmmss");
		
		
		System.out.println(forr.format(new Date(nano)));
		
		/*long terminalAvailabilityPeriod = 10;
		long e = System.nanoTime();
		System.out.println(new Date(e));
		long ll= TimeUnit.SECONDS.toNanos(terminalAvailabilityPeriod);
		
		System.out.println(new Date(ll));*/
		
		//System.out.println(nano);

		
	}
	





}
