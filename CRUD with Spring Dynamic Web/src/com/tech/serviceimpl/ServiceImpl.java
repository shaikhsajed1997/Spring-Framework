package com.tech.serviceimpl;

import java.util.List;

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
	public int saveData(Account ac) {

		return di.saveData(ac);
	}

	@Override
	public List<Account> getAllData(String us, String pass) {

		return di.getAllData(us, pass);
	}

	@Override
	public List<Account> getSingleData(String us, String pass) {

		return di.getSingleData(us, pass);
	}

	@Override
	public void deleteData(int aadhar_Number) {
		
		di.deleteData(aadhar_Number);                       
		
	}

	@Override
	public List<Account> getData() {
		
		return di.getData();
	}

	

	

	@Override
	public Account editData(int aadhar_Number) {
		
		return di.editData(aadhar_Number);
	}

}
