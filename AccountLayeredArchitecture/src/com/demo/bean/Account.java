package com.demo.bean;

//Importing Packages
import java.util.Scanner;
import com.demo.exception.*;
abstract public class  Account {
	
	Scanner sc=new Scanner(System.in);
	
	//Initializing instance variables
	private int accId;
	private String accName;
	private int accPin;
	protected double accBalance;
	
	//Default Constructor
	public Account() {
		accId=0;
		accName=null;
		accPin=0;
		accBalance=0.0;	
	}
	
	//Parameterised Constructor
	public Account(int accId, String name, int accPin, double accBalance) {
		
		
		this.accId = accId;
		this.accName = name;
		this.accPin = accPin;
		this.accBalance = accBalance;
	}

	
	//Getters & Setters
	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getName() {
		return accName;
	}

	public void setName(String name) {
		this.accName = name;
	}

	public int getAccPin() {
		return accPin;
	}

	public void setAccPin(int accPin) {
		this.accPin = accPin;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public double deposit(double amt) {
		accBalance=accBalance+amt;
		return accBalance;
	}
	public int changePinNo(int pin) {
		int newPin=pin;
		return newPin;
		
	}
	
	//Method prototype declaration
	abstract public double withdraw(double amt);
	abstract public double calInterest();
	
	@Override
	public String toString() {
		return "Id : "+accId+"\nName : "+accName+"\nBalance : "+accBalance+"\nInterest :"+calInterest();
		
	}
	
	

}
