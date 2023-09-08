package com.tech.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	private long aadhar_Number;
	
	private long account_Number;
	
	private String account_Type;
	
	private String acc_Holder_Name;
	
	private String mobile_Number;
	
	private String email_Id;
	
	private String address;
	
	private double account_Balance;
	
	private String user_Name;
	
	private String password;
	
	@OneToMany( mappedBy = "account", fetch = FetchType.EAGER)
	private List<AccountTransaction> transaction;

	public List<AccountTransaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<AccountTransaction> transaction) {
		this.transaction = transaction;
	}

	public String getAccount_Type() {
		return account_Type;
	}

	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}

	public long getAadhar_Number() {
		return aadhar_Number;
	}

	public void setAadhar_Number(long aadhar_Number) {
		this.aadhar_Number = aadhar_Number;
	}

	public long getAccount_Number() {
		return account_Number;
	}

	public void setAccount_Number(long account_Number) {
		this.account_Number = account_Number;
	}

	public String getAcc_Holder_Name() {
		return acc_Holder_Name;
	}

	public void setAcc_Holder_Name(String acc_Holder_Name) {
		this.acc_Holder_Name = acc_Holder_Name;
	}

	public String getMobile_Number() {
		return mobile_Number;
	}

	public void setMobile_Number(String mobile_Number) {
		this.mobile_Number = mobile_Number;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAccount_Balance() {
		return account_Balance;
	}

	public void setAccount_Balance(double account_Balance) {
		this.account_Balance = account_Balance;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
