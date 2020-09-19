package com.demo.test;
import java.util.Scanner;

import com.demo.exception.*;

import com.demo.bean.*;
import com.demo.service.*;

public class TestAccount {

	public static void main(String[] args) {
		int choice=0;
		
		double balance=0.0;
		AccountServiceImpl accountServiceImpl=new AccountServiceImpl();
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1.Create Account");
			System.out.println("2.Withdrawal");
			System.out.println("3.Deposit");
			System.out.println("4.Transfer Funds");
			System.out.println("5.Change pin");
			System.out.println("6.Check Balance");
			System.out.println("7.Display account by Id");
			System.out.println("8.Exit");
			System.out.println("Choice");
			choice=sc.nextInt();
				
			switch(choice) {
			case 1:
				System.out.println("Enter the type of account :");
				String type=sc.next();
				
				accountServiceImpl.acceptAccountData(type);
				
				System.out.println("Account Creation Successful !");
				
				break;
			case 2:
				System.out.println("Enter id to do withdrawal");
				int id=sc.nextInt();
				System.out.println("Enter amount to be withdrawn");
				double amt=sc.nextInt();
				
				try {
					
					balance=accountServiceImpl.withdrawAmt(id, amt);
					
					System.out.println("Withdrawal Successful");
					System.out.println("Balance is:"+balance);
				} catch (AccountNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				
				break;
			case 3:
				System.out.println("Enter id to deposit amount :");
				id=sc.nextInt();
				System.out.println("Enter the amount to be deposited:");
				amt=sc.nextInt();
				try {
					//Identifies the account to which amount is to be deposited
					balance=accountServiceImpl.depositAmt(id, amt);
					System.out.println("Amount Deposited !");
					System.out.println("Balance : "+balance);
				}catch(AccountNotFoundException a1) {
					System.out.println(a1.getMessage());
				}
					
				
			
				break;
			case 4:
				System.out.println("Enter the id from which amount is to be transferred:");
				int id1=sc.nextInt();
				System.out.println("Enter the id to which amount is to be transferred:");
				int id2=sc.nextInt();
				System.out.println("Enter the amount to be transferred");
				amt=sc.nextInt();
				try {
					accountServiceImpl.transferAmt(id1, id2, amt);
					System.out.println("Transfer successful!");
				}catch(AccountNotFoundException a2) {
					System.out.println(a2.getMessage());
				}
				
				break;
			case 5:
				System.out.println("Enter your id");
				id=sc.nextInt();
				System.out.println("Enter your old pin");
				int p1=sc.nextInt();
				System.out.println("Enter the pin you want to set");
				int p2=sc.nextInt();
				int newPin=0;
				try {
					
					newPin=accountServiceImpl.changePin(id, p1, p2);
					System.out.println("Pin change successful");
					System.out.println("New Pin is:"+newPin);
				}catch(AccountNotFoundException a3) {
					System.out.println(a3.getMessage());
				}catch(IncorrectPinException i) {
					System.out.println(i.getMessage());
				}
			
				
				break;
			case 6:
				System.out.println("Enter id : ");
				id=sc.nextInt();
				try {
					System.out.println("Balance is : "+accountServiceImpl.checkBalance(id));
				}catch(AccountNotFoundException a4) {
					System.out.println(a4.getMessage());
				}
				
				break;
			case 7:
				System.out.println("Enter id : ");
				id=sc.nextInt();
				try {
					Account a=accountServiceImpl.displayAccount(id);
					System.out.println(a);
				}catch(AccountNotFoundException a5) {
					System.out.println(a5.getMessage());
				}
				
				break;
			case 8:
				break;
			default:
				System.out.println("Wrong Choice ! Press 8 to exit !");
				break;
			
			}
			
		}while((choice!=8));
	}

}
