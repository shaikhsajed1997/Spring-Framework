package com.tech.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.daoi.DaoI;
import com.tech.model.Account;

@Repository
public class DaoImpl implements DaoI {

	@Autowired
	SessionFactory sf;

	@Override
	public int saveData(Account ac) {

		Session sn = sf.openSession();

		Transaction tx = sn.beginTransaction();

		//int aadhar_Number = (int) sn.save(ac);
		sn.saveOrUpdate(ac);
		tx.commit();

		sn.close();

		return 1;
	}

	@Override
	public List<Account> getAllData(String us, String pass) {

		Session sn = sf.openSession();

		List<Account> list = sn.createQuery("from Account").list();
		return list;
	}

	@Override
	public List<Account> getSingleData(String us, String pass) {

		Session sn = sf.openSession();

		Query<Account> q = sn.createQuery("from Account where user_Name=:user and password=:ps");
		q.setParameter("user", us);
		q.setParameter("ps", pass);
		List<Account> list = q.getResultList();

		return list;
	}

	@Override
	public void deleteData(int aadhar_Number) {
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Account ac = sn.get(Account.class, aadhar_Number);

		sn.delete(ac);
		tr.commit();
		sn.close();

	}

	@Override
	public List<Account> getData() {
		Session sn = sf.openSession();

		Query<Account> q = sn.createQuery("from Account");

		List<Account> aclist = q.getResultList();

		return aclist;
	}

	@Override
	public Account editData(int aadhar_Number) {

		Session sn = sf.openSession();
		Account ac = sn.get(Account.class, aadhar_Number);
		return ac;
	}

}
