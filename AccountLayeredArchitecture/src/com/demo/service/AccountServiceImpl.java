package com.demo.service;

//Importing packages
import java.util.Scanner;
import com.demo.dao.*;
import com.demo.exception.*;
import com.demo.bean.*;

public class AccountServiceImpl implements AccountService{
	//Static block
	static {
		sc=new Scanner(System.in);	
	}
	
	//Instance variables
	static Scanner sc;
	private AccountDao accountDao;
	
	//Default Constructor
	public  AccountServiceImpl() {
		this.accountDao=new AccountDaoImpl();
	}
	
	//To create new account(savings or current)
	public void acceptAccountData(String type) {
		
		System.out.println("Enter the id : ");
		int id=sc.nextInt();
		System.out.println("Enter the name : ");
		String name=sc.next();
		System.out.println("Enter the pin : ");
		int pin=sc.nextInt();
		System.out.println("Enter the balance : ");
		double balance=sc.nextDouble();
		if(type.equalsIgnoreCase("Savings")) {
			System.out.println("Enter checkbook number");                            
			String cbNo=sc.next();
			Account a=new Savings(id,name,pin,balance,cbNo);
			accountDao.addAccount(a);
			}
		else if(type.equalsIgnoreCase("Current")) {
			Account a=new Current(id,name,pin,balance);
			accountDao.addAccount(a);
		}
	}
	
	//To withdraw amount
	public double withdrawAmt(int id,double amount)throws AccountNotFoundException {
		Account a=accountDao.searchByAccId(id);
		if(a!=null) {
			double balance=a.withdraw(amount);
			return balance;
		}
		return -1;
	}
	
	//To deposit amount
	public double depositAmt(int id,double amount)throws AccountNotFoundException {
		Account a=accountDao.searchByAccId(id);
		if(a!=null) {
			double balance=a.deposit(amount);
			return balance;
		}
		return -1;
	}
	
	//To transfer amount from one acount to another
	public void transferAmt(int id1,int id2,double amount)throws AccountNotFoundException {
		Account a1=accountDao.searchByAccId(id1);
		Account a2=accountDao.searchByAccId(id2);
		if((a1!=null) && (a2!=null)) {
			a1.withdraw(amount);
			a2.deposit(amount);
		}
	}
	
	//To change pin of an account
	public int changePin(int id,int p1,int p2)throws AccountNotFoundException, IncorrectPinException {
		Account a=accountDao.searchByAccId(id);
		if(a!=null) {
			if(a.getAccPin()==p1) {
				int newPin=a.changePinNo(p2);
				return newPin;
			}
		}
		throw new IncorrectPinException("Wrong Pin entered!Please try again");
	}
	
	//To display balance of an account
	public double checkBalance(int id)throws AccountNotFoundException {
		Account a=accountDao.searchByAccId(id);
		if(a!=null) {
			return a.getAccBalance();
		}
		return -1;
	}
	
	//To display all the details of the account
	public Account displayAccount(int id)throws AccountNotFoundException {
		Account a=accountDao.searchByAccId(id);
		if(a!=null) {
			return a;
		}
		return null;
	}
}
