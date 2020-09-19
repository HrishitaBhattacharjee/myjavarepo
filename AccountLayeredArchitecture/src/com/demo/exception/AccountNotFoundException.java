package com.demo.exception;

//Exception for Account not found
public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String msg) {
		//Overwriting the predefined message of Exception class
		super(msg);
	}

}
