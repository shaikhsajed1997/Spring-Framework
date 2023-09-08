package com.tech.servicei;

import java.util.List;

import com.tech.model.Account;

public interface ServiceI {

	//for creating new bank account
	public long createAccount(Account ac);

	//get all account details present in bank db
	public List<Account> showAllAccount(String us, String pass);

	//show perticural single account details
	public List<Account> showAccount(String us, String pass);

	//delete single account from bank db
	public void deleteAccount(long aadhar);

	//show all account present in bank db after delete
	public List<Account> getAccount();

	//customer see the available balance in account
	public Account getBalance(long aadhar);

	//deposit amount in perticular bank account
	public void addBalance(Account ac);

	//withdraw amount from account
	public double updateMoney(Account ac);
	
	//show the account details to customer for updatation
	public Account editAccount(long aadhar);
	
	//those details updated by customer is update in bank database
	public void updateAccount(Account ac);

}
