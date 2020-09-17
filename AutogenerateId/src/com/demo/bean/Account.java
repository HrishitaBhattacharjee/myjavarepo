package com.demo.bean;

//Importing Packages
import java.util.Date;
import java.util.Scanner;

import com.demo.service.*;
import com.demo.test.*;


public class Account {
	static {
		cnt=0;
	}
	Scanner sc=new Scanner(System.in);
	private static int cnt;
	//Intializing instance variables
	private int accId;
	private String accName;
	private Date oDate;
	private String accType;
	private double accBalance;
	
	//Default Constructor
	public Account() {
		accId=++cnt;
		accName=null;
		oDate=null;
		accType=null;
		accBalance=0.0;
	}
	
	//Parameterised Constructor
	public Account(String name,Date dt,String type,double balance) {
		this.accId=++cnt;
		this.accName=name;
		this.oDate=dt;
		this.accType=type;
		this.accBalance=balance;
	}
	
	//Setter & Getter methods
	public int getAccId() {
		return accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public Date getoDate() {
		return oDate;
	}

	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	
	//To calculate balance after withdrawal
	public double withdraw(double amt) {
		if((accBalance-10000)>=amt)
		{
			accBalance=accBalance-amt;
		}
		return accBalance;
	}
	
	//To calculate balance after deposit
	public double deposit(double amt) {
		accBalance=accBalance+amt;
		return accBalance;
	}
	
	@Override
	public String toString() {
		return "Id : "+accId+"\nName : "+accName+"\nDate of opening : "+oDate+ "\nType of Account : "+accType+"\nBalance : "+accBalance;
		
	}
	

}
