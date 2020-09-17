package com.demo.service;
//Importing Packages
import com.demo.bean.*;
import com.demo.test.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class AccountService {
	
	
	public static Scanner sc=new Scanner(System.in);
	public static SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
	
	//To accept account details from the user
	public static void acceptAccountData(Account[] acc) {
		for(int i=0;i<acc.length;i++) {
			System.out.println("Enter Account Holder's Name:");
			String name=sc.next();
			System.out.println("Enter date of opening account:");
			String date=sc.next();
			System.out.println("Enter the account type:");
			String type=sc.next();
			System.out.println("Enter the account balance :");
			double balance=sc.nextDouble();
			try {
				Date dt=sdf.parse(date);
				acc[i]=new Account(name,dt,type,balance);
			}catch(ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	//To display account details to the user
	public static void displayAccount(Account[] acc,int id) {
		int pos=searchById(acc, id);
		System.out.println(acc[pos]);																																											
	}
	
	//To withdraw amount from the specific account
	public static double withdrawAmount(Account[] acc,int id,double amt) {
		int pos=searchById(acc,id);
		if(pos!=-1) {
			double balance=acc[pos].withdraw(amt);
			return balance;
		}
		else {
			return -1;
		}
	}
	
	//To deposit amount to the specific account
	public static double depositAmount(Account[] acc,int id,double amt) {
		
		int pos=searchById(acc,id);
		if(pos!=-1) {
			double balance=acc[pos].deposit(amt);
			return balance;
		}
		else {
			return -1;
		}
	}
	
	//To search for the specific account
	public static int searchById(Account[] acc, int id) {
		for(int i=0;i<acc.length;i++) {
			if(acc[i].getAccId()==id) {
				return i;
			}
		}
		return -1;
	}
}
		


