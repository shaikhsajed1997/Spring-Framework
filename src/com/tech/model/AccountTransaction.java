package com.tech.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AccountTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int t_Id;
	
	private Date date;
	
	private double amount;
	
	private String debit_credit;
	
	private double total_Balance;
	
	@ManyToOne
	private Account account;

	public int getT_Id() {
		return t_Id;
	}

	public void setT_Id(int t_Id) {
		this.t_Id = t_Id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDebit_credit() {
		return debit_credit;
	}

	public void setDebit_credit(String debit_credit) {
		this.debit_credit = debit_credit;
	}

	public double getTotal_Balance() {
		return total_Balance;
	}

	public void setTotal_Balance(double total_Balance) {
		this.total_Balance = total_Balance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
