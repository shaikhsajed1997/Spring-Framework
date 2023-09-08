package com.tech.daoi;

import java.util.List;

import com.tech.model.Account;

public interface DaoI {

	public long createAccount(Account ac);

	public List<Account> showAllAccount(String us, String pass);

	public List<Account> showAccount(String us, String pass);

	public void deleteAccount(long aadhar);

	public List<Account> getAccount();

	public Account getBalance(long aadhar);

	public void addBalance(Account ac);

	public double updateMoney(Account ac);
	
	public Account editAccount(long aadhar);
	
	public void updateAccount(Account ac);

}
