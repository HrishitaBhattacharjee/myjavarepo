package com.demo.dao;

//Importing packages
import com.demo.bean.*;
import com.demo.exception.*;

public class AccountDaoImpl implements AccountDao{
	
	//Static block
	static {
		acc=new Account[20];
		cnt=0;
	}
	
	//Instance variables
	static Account[] acc;
	static int cnt;
	
	//To add the account to the database
	public void addAccount(Account a) {
		acc[cnt]=a;
		cnt++;
	}
	
	//To search an account by its id in the database
	public Account searchByAccId(int id)throws AccountNotFoundException {
		for(Account a:acc) {
				if(a!=null) {
					if(a.getAccId()==id) {
						return a;
					}
				}
			}
		throw new AccountNotFoundException("Account not found !");
	}
}
	

