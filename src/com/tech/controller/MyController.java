package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.model.Account;
import com.tech.model.AccountTransaction;
import com.tech.servicei.ServiceI;

@Controller
public class MyController {

	@Autowired
	ServiceI si;

	@RequestMapping("/newaccount")
	public String createAccount(Account ac) {

		if (ac.getAccount_Balance() >= 500) {
			long aadhar = si.createAccount(ac);
			if (aadhar != 0) {
				return "index";
			} else {
				return "createacc";
			}
		} else {
			return "massage";
		}

	}

	@RequestMapping("/log")
	public String showAccount(@RequestParam("user_Name") String us, @RequestParam("password") String pass, Account ac,
			Model m) {

		List<Account> aclist = si.showAllAccount(us, pass);
		if (us.equals("admin") && pass.equals("admin@95")) {

			m.addAttribute("data", aclist);
			return "display";

		} else if (us.equals(us) && pass.equals(pass)) {

			List<Account> acc = si.showAccount(us, pass);
			if (acc.isEmpty() == false) {

				m.addAttribute("data", acc);
				return "display";
			} else {
				return "index";
			}
		}

		return null;

	}

	@RequestMapping("/delete")
	public String deleteAccount(@RequestParam("rd") long aadhar, Account ac, Model m) {

		si.deleteAccount(aadhar);
		List<Account> ls = si.getAccount();
		m.addAttribute("data", ls);
		return "display";

	}

	@RequestMapping("/balance")
	public String balanceAmt(@RequestParam("rd") long aadhar, Account ac, Model m) {

		Account acc = si.getBalance(aadhar);
		m.addAttribute("data", acc);
		return "deposit";

	}

	@RequestMapping("/updatebalance")
	public String addBalance(@ModelAttribute Account ac, Model m) {

		if (ac.getAccount_Balance() > 0) {
			si.addBalance(ac);

			List<Account> aclist = si.getAccount();
			m.addAttribute("data", aclist);
			return "display";
		} else {
			return "Invalid amount";
		}
	}

	@RequestMapping("/withdraw")
	public String balanceWithdraw(@RequestParam("rd") long aadhar, Account ac, Model m) {

		Account acc = si.getBalance(aadhar);
		m.addAttribute("data", acc);

		return "withdraw";

	}

	@RequestMapping("/withdrawbalance")
	public String withdraw(@ModelAttribute Account ac, Model m) {

		double amount = si.updateMoney(ac);
		if (amount >= 500) {
			List<Account> aclist = si.getAccount();
			m.addAttribute("data", aclist);
			return "display";
		} else {
			return "balancealert";
		}

	}

	@RequestMapping("/editaccount")
	public String editAccount(@RequestParam("rd") long aadhar, Account ac, Model m) {

		Account acc = si.editAccount(aadhar);
		
		m.addAttribute("data", acc);

		return "updateaccount";

	}

	@RequestMapping("/update")
	public String updateAccount(@ModelAttribute Account ac, Model m) {

		si.updateAccount(ac);
		List<Account> aclist = si.getAccount();
		m.addAttribute("data", aclist);
		return "display";

	}
	@RequestMapping("/transactionhistory")
	public String getTransactionHistory(@RequestParam("rd") long aadhar,Model m) {
		
		Account acc=si.editAccount(aadhar);
		List<AccountTransaction> act=acc.getTransaction();
		
		m.addAttribute("data", act);
		return "transaction";
		
	}

}
