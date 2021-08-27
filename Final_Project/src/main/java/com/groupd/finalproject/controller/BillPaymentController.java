package com.groupd.finalproject.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupd.finalproject.bean.Bill;
import com.groupd.finalproject.bean.CustomerAccount;
import com.groupd.finalproject.dao.CustomerAccountDao;
//import com.groupd.finalproject.dao.BillPaymentDao;

@Controller
public class BillPaymentController {
	@Autowired
	CustomerAccountDao dao1;

	@RequestMapping(value = "/payBillForm", method = RequestMethod.GET)
	public String showBillForm(Model m) {
		m.addAttribute("command", new Bill());
		return "paybills";
	}

//	@ModelAttribute("acc") CustomerAccount acc,
	@RequestMapping(value = "/payBill", method = RequestMethod.POST)
	public String payBill( Model m, @RequestParam String BillerName,
			@RequestParam String BillerAcctNo, @RequestParam String Amt, @RequestParam String CustomerId,
			HttpServletResponse response) {
		// payBill to be changed
		if (dao1.payBill( BillerName, BillerAcctNo, Amt, CustomerId) != -1) {
			return "redirect:/";
		}
		// Otherwise show error message
		m.addAttribute("message", "Invalid Details!");
		return "/";
	}

	@RequestMapping("/payFees")
	public String showWithdrawForm(Model m) {
		m.addAttribute("command", new Bill());
		return "payfees";
	}
	@RequestMapping(value = "/payFeesProcess", method = RequestMethod.POST)
	public String processWithdraw( Model m, @RequestParam String BillerName,
			@RequestParam String BillerAcctNo, @RequestParam String Amt, @RequestParam String CustomerId, HttpServletResponse response) {

		if (dao1.withdrawMoney( BillerName, BillerAcctNo, Amt, CustomerId) != -1) {

			return "redirect:showBalance";
		}
		m.addAttribute("message", "Invalid Details!");
		return "/";
	}
	
	
	
//	@RequestMapping("/payFees")
//	public String showFeesForm(Model m) {
//
//		return "payfees";
//	}
//
//	@RequestMapping(value = "/payFees", method = RequestMethod.POST)
//	public String payBill(@ModelAttribute("acc") CustomerAccount acc, Model m, @RequestParam String amount,
//			HttpServletResponse response) {
//
//		if (dao1.payFees(acc, amount) != -1) {
//
//			return "redirect:/";
//		}
//		m.addAttribute("message", "Invalid Details!");
//		return "/";
//	}
}
