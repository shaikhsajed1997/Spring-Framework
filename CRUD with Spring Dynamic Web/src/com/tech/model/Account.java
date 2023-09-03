package com.tech.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private int aadhar_Number;

	private int account_Number;

	private String acc_Holder_Name;

	private String mobile_Number;

	private String address;

	private String user_Name;

	private String password;

	public int getAadhar_Number() {
		return aadhar_Number;
	}

	public void setAadhar_Number(int aadhar_Number) {
		this.aadhar_Number = aadhar_Number;
	}

	public int getAccount_Number() {
		return account_Number;
	}

	public void setAccount_Number(int account_Number) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
