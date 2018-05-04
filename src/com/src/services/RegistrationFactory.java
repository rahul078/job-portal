package com.src.services;

public class RegistrationFactory {

	private RegistrationFactory(){
	
	}

	private static DbInterface di;
	
	
	public static DbInterface getInstance(){
		di=new DbImpl();
		return di;
		
	}
	
}
