package com.demo.bean;

import com.demo.exception.*;

public class Savings extends Account {
	
	//Instance Variables
	private final int  iRate=5;
	private String checkbookNo;
	
	//Default Constructor
	public Savings() {
		checkbookNo=null;
	}
	
	//Parameterized Constructor
	public Savings(int accId, String name, int accPin, double accBalance,String checkbookNo) {
		super(accId,name,accPin,accBalance);
		this.checkbookNo=checkbookNo;
	}
	
	//To withdraw amount from savings account
	public double withdraw(double amt) 
	{
		if((accBalance-10000)>=amt) {
			accBalance=accBalance-amt;
		}
		return accBalance;
		
		
	//To calculate interest of savings account	
	}
	public double calInterest() {
		double interest=0.0;
		if(accBalance>=50000) {
			interest=((accBalance)*iRate)+(0.02*accBalance);
		}
		else {
			interest=(accBalance)*iRate;
		}
		return interest;
	}
	
	//To print savings account
	@Override
	public String toString() {
		return super.toString()+"iRate=" + iRate + "checkbookNo=" + checkbookNo;
	}
	
}