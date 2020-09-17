package com.demo.test;
//Importing Packages
import java.util.Scanner;

import com.demo.bean.*;
import com.demo.service.*;

public class TestAccountClass {
	
	public static void main(String[] args) {
		//Initializing array of Account type objects
		Account [] a=new Account[3];
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		
		do {
			System.out.println("1.Create new account");
			System.out.println("2.To withdraw amount");
			System.out.println("3.To deposit amount");
			System.out.println("4.Display by id");
			System.out.println("5.Exit");
			System.out.println("Choice :");
			choice=sc.nextInt();
			
			//Switch case to input the user's choice 
			switch(choice) {
			//To create Account
			case 1:
				AccountService.acceptAccountData(a);
				break;
			//To withdraw amount
			case 2:
				System.out.println("Enter id to withdraw amount:");
				int id=sc.nextInt();
				System.out.println("Enter the amount to be withdrawn:");
				double amt=sc.nextDouble();
				//Identifies the account from which amount is to be withdrawn
				int pos=AccountService.searchById(a,id);
				if(pos!=-1) {
					double balance=AccountService.withdrawAmount(a, id, amt);
					System.out.println("Amount Withdrawn !");
					System.out.println("Balance : "+balance);
				}
				else {
					System.out.println("Person not found");
				}
				break;
			//To deposit amount
			case 3:
				System.out.println("Enter id to deposit amount :");
				id=sc.nextInt();
				System.out.println("Enter the amount to be deposited:");
				amt=sc.nextDouble();
				//Identifies the account to which amount is to be deposited
				pos=AccountService.searchById(a,id);
				if(pos!=-1) {
					double balance1=AccountService.depositAmount(a, id, amt);
					System.out.println("Amount Deposited !");
					System.out.println("Balance : "+balance1);
				}
				else {
					System.out.println("Person not found");
				}
				break;
			//To display account
			case 4:
				System.out.println("Enter id to display account :");
				id=sc.nextInt();
				pos=AccountService.searchById(a,id);
				if(pos!=-1) {
					AccountService.displayAccount(a, id);
				}
				else {
					System.out.println("Person not found");
				}
				break;
			}
		}while(choice!=5);	
	}

}
