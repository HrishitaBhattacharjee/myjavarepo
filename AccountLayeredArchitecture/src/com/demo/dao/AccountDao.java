package com.demo.dao;

//Importing packages
import com.demo.bean.*;
import com.demo.exception.*;
public interface AccountDao {
	
	//Method prototype declaration
	void addAccount(Account a);
	Account searchByAccId(int id)throws AccountNotFoundException;

}
