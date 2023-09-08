package com.tech.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.daoi.DaoI;
import com.tech.model.Account;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	DaoI di;

	@Override
	public long createAccount(Account ac) {

		return di.createAccount(ac);
	}

	@Override
	public List<Account> showAllAccount(String us, String pass) {

		return di.showAllAccount(us, pass);
	}

	@Override
	public List<Account> showAccount(String us, String pass) {

		return di.showAccount(us, pass);
	}

	@Override
	public void deleteAccount(long aadhar) {

		di.deleteAccount(aadhar);

	}

	@Override
	public List<Account> getAccount() {

		return di.getAccount();
	}

	@Override
	public Account getBalance(long aadhar) {

		return di.getBalance(aadhar);
	}

	@Override
	public void addBalance(Account ac) {

		di.addBalance(ac);

	}

	@Override
	public double updateMoney(Account ac) {

		return di.updateMoney(ac);

	}

	@Override
	public Account editAccount(long aadhar) {
		
		
		return di.editAccount(aadhar);
		
		
	}

	@Override
	public void updateAccount(Account ac) {
		
		di.updateAccount(ac);
		
	}

}
