package com.tech.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tech.daoi.DaoI;
import com.tech.model.Account;
import com.tech.model.AccountTransaction;

@Repository
public class DaoImpl implements DaoI {

	@Autowired
	SessionFactory sf;

	AccountTransaction act = new AccountTransaction();

	// create new account
	@Override
	public long createAccount(Account ac) {

		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();

		act.setDate(new Date());
		act.setDebit_credit("Credit");
		act.setAmount(ac.getAccount_Balance());
		act.setTotal_Balance(ac.getAccount_Balance());
		act.setAccount(ac);

		List<AccountTransaction> list = new ArrayList<>();
		list.add(act);
		ac.setTransaction(list);

		Query q = sn.createQuery("from Account where account_Number=:acc");
		q.setParameter("acc", ac.getAccount_Number());
		List<Account> l = q.getResultList();
		if (l.isEmpty()) {
			long aadhar = (long) sn.save(ac);
			sn.save(act);
			tr.commit();
			sn.close();
			return aadhar;
		}
		return 0;
	}

	// show all account details in db
	@Override
	public List<Account> showAllAccount(String us, String pass) {

		Session sn = sf.openSession();

		Query q = sn.createQuery("from Account");

		List<Account> aclist = q.getResultList();

		sn.close();

		return aclist;
	}

	// show single account details
	@Override
	public List<Account> showAccount(String us, String pass) {

		Session sn = sf.openSession();

		Query<Account> q = sn.createQuery("from Account where user_Name=:us and password=:pass");
		q.setParameter("us", us);
		q.setParameter("pass", pass);

		List<Account> list = q.getResultList();

		sn.close();
		return list;
	}

	// delete perticular single account
	@Override
	public void deleteAccount(long aadhar) {

		Session sn = sf.openSession();

		Transaction tr = sn.beginTransaction();

		Account ac = sn.get(Account.class, aadhar);

		sn.delete(ac);

		tr.commit();
		sn.close();
	}

	// show all account details after delete any account
	@Override
	public List<Account> getAccount() {
		Session sn = sf.openSession();

		Query q = sn.createQuery("from Account");

		List<Account> aclist = q.getResultList();

		sn.close();

		return aclist;

	}

	// show total balance in there account
	@Override
	public Account getBalance(long aadhar) {

		Session sn = sf.openSession();

		Account ac = sn.get(Account.class, aadhar);
		sn.close();
		return ac;
	}

	// update account balance after deposit amount in account
	@Override
	public void addBalance(Account ac) {

		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		
		act.setDate(new Date());
		act.setDebit_credit("Credit");
		act.setAmount(ac.getAccount_Balance());
		
		long a = ac.getAadhar_Number();
		Account acc = sn.get(Account.class, a);
		double amt = acc.getAccount_Balance();
		
		
		double amt1 = ac.getAccount_Balance();
		double total = amt + amt1;
		
		act.setTotal_Balance(total);
		act.setAccount(acc);
		
		Query q = sn.createQuery("update Account set account_Balance=:am where aadhar_Number=:an");
		q.setParameter("am", total);
		q.setParameter("an", a);
		q.executeUpdate();
		
		sn.save(act);
		tr.commit();
		sn.close();

	}

	// update account balance after withdraw amount from account
	@Override
	public double updateMoney(Account ac) {
		Session sn = sf.openSession();

		long a = ac.getAadhar_Number();
		Account acc = sn.get(Account.class, a);
		double amt = acc.getAccount_Balance();
		
		Transaction tr = sn.beginTransaction();
		double amt1 = ac.getAccount_Balance();
		double total = amt - amt1;
		if (total >= 500) {
			
			act.setDate(new Date());
			act.setDebit_credit("Debit");
			act.setAmount(ac.getAccount_Balance());
			act.setAccount(acc);
			act.setTotal_Balance(total);
			
			Query q = sn.createQuery("update Account set account_Balance=:am where aadhar_Number=:an");
			q.setParameter("am", total);
			q.setParameter("an", a);
			q.executeUpdate();

			sn.save(act);
			tr.commit();
			sn.close();
		
		}
		return total;

	}

	// show available account details to customer for updation
	@Override
	public Account editAccount(long aadhar) {

		Session sn = sf.openSession();

		Account ac = sn.get(Account.class, aadhar);

		sn.close();
		return ac;

	}

	// update there newly changes in account details by customer
	@Override
	public void updateAccount(Account ac) {

		Session sn = sf.openSession();

		Transaction tr = sn.beginTransaction();

		sn.update(ac);

		tr.commit();

		sn.close();

	}

}
