package com.tech.servicei;

import java.util.List;

import com.tech.model.Account;

public interface ServiceI {
	
	public int saveData(Account ac);
	
	public List<Account> getAllData(String us,String pass);
	
	public List<Account> getSingleData(String us, String pass);
	
	public void deleteData(int aadhar_Number);
	
	public List<Account> getData();
	
	public Account editData(int aadhar_Number);
	
	

}
