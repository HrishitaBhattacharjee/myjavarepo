package com.demo.bean;

public class Current extends Account {
	
	//Instance Variables
	private static final int iRate=2;
	private final int noOfTransc=3;
	
	//Default Constructor
	public Current() {
		super();
	}
	
	//Parameterized Constructor
	public Current(int accId, String name, int accPin, double accBalance) {
		super(accId,name,accPin,accBalance);
	}
	
	//To withdraw amount from current account
	public double withdraw(double amt) {
		accBalance=accBalance-amt;
		return accBalance;
	}
	
	//To calculate interest of current account
	public double calInterest() {
		double interest=0.0;
		interest=accBalance*iRate;
		return interest;
	}
	
	//To display current account
	@Override
	public String toString() {
		return super.toString()+"iRate=" + iRate ;
	}
	
	

}
