package com.demo.service;

//Importing packages
import com.demo.bean.Account;
import com.demo.exception.AccountNotFoundException;
import com.demo.exception.IncorrectPinException;


public interface AccountService {
	
	//Method prototype declaration
	void acceptAccountData(String type);
	double withdrawAmt(int id,double amount)throws AccountNotFoundException;
	double depositAmt(int id,double amount)throws AccountNotFoundException;
	void transferAmt(int id1,int id2,double amount)throws AccountNotFoundException;
	int changePin(int id,int p1,int p2)throws AccountNotFoundException,IncorrectPinException;
	double checkBalance(int id)throws AccountNotFoundException;
	Account displayAccount(int id)throws AccountNotFoundException;
	
}
