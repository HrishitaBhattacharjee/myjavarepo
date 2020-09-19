package com.demo.exception;

//Exception for incorrect pin
public class IncorrectPinException extends Exception{
	public IncorrectPinException(String msg) {
		//Overwriting predefined message of Exception class
		super(msg);
	}
}
