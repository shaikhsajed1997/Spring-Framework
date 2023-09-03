package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.model.Account;
import com.tech.servicei.ServiceI;

@Controller
public class HomeController {

	@Autowired
	ServiceI sci;

	@RequestMapping("/reg")
	public String saveData(Account ac) {

		int aadhar_Number = sci.saveData(ac);
		if (aadhar_Number > 0) {

			return "index";
		} else {
			return "registration";
		}

	}

	@RequestMapping("/log")
	public String getAllData(@RequestParam("user_Name") String us, @RequestParam("password") String pass, Account ac,
			Model m) {

		if (us.equals("admin") && pass.equals("admin@123")) {
			List<Account> aclist = sci.getAllData(us, pass);
			m.addAttribute("data", aclist);
			return "data";
		} else if (us.equals(us) && pass.equals(pass)) {

			List<Account> acclist = sci.getSingleData(us, pass);
			m.addAttribute("data", acclist);
			return "data";
		}
		return "index";
	}

	@RequestMapping("/delete")
	public String deleteData(@RequestParam("rd") int aadhar_Number,  Model m) {

		sci.deleteData(aadhar_Number);

		List<Account> ac = sci.getData();
		m.addAttribute("data", ac);

		return "data";

	}
	@RequestMapping("/edit")
	public String editData(@RequestParam("rd") int aadhar_Number,Model m) {
		
		Account ac=sci.editData(aadhar_Number);
		m.addAttribute("data", ac);
		
		return "update";
		
	}
	@RequestMapping("/update")
	 public String updateData(@ModelAttribute Account ac, Model m) {
		
		sci.saveData(ac);
	    List<Account> aclist=	sci.getData();
	    m.addAttribute("data", aclist);
		return "data";
		 
	 }

}
