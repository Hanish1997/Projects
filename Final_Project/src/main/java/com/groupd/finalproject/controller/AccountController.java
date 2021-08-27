package com.groupd.finalproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupd.finalproject.bean.Bill;
import com.groupd.finalproject.bean.Customer;
import com.groupd.finalproject.bean.CustomerAccount;
import com.groupd.finalproject.bean.Login;
import com.groupd.finalproject.dao.CustomerAccountDao;
import com.groupd.finalproject.dao.LoginDao;
@Controller
public class AccountController {

	
	@Autowired
	CustomerAccountDao dao1;
	
//	@RequestMapping("/showBalance")
//	public String showBalance(@ModelAttribute("acc") CustomerAccount acc,  Model m )  {
//		List<CustomerAccount> list = dao1.getAllBalance( acc);
//		m.addAttribute("list", list);
//		return "showbalance";
//	}
	@RequestMapping(value ="/addAccount", method = RequestMethod.GET)
	public String showform(@ModelAttribute("acc") CustomerAccount acc,Model m) {
		//System.out.println("Hello dear");
		m.addAttribute("acc", new CustomerAccount());
		return "addAccount";
	}
	
	@RequestMapping(value ="/showBalance", method = RequestMethod.GET)
	public String showbalance(@ModelAttribute("acc") CustomerAccount acc,Model m) {
		//System.out.println("Hello dear");
		//m.addAttribute("acc", new CustomerAccount());
		System.out.println("The customerid is : "+acc.getCustomerId());
		Customer l = dao1.getLoginId(acc.getCustomerId());
		System.out.print("The LoginId received is "+l.getLoginId());
		
		List<CustomerAccount> listCA = dao1.getAllBalance(l.getLoginId());
		ArrayList<String[]> list = new ArrayList<String[]>() ;
//		List<String> list[] = new List<String>[listCA.size()];
//		System.out.println(list.get(0)+"  list==============================");
		for(int i = 0; i < listCA.size();i++) {
			String[] lArr = new String[4];
			lArr[0] = listCA.get(i).getAcctNo();
			System.out.println(listCA.get(i).getAcctNo());
			
			lArr[1] = listCA.get(i).getAcctType();
			System.out.println(listCA.get(i).getAcctType());
			
			lArr[2] = listCA.get(i).getAcctBalance();
			System.out.println(listCA.get(i).getAcctBalance());
			
			lArr[3] = listCA.get(i).getCustomerId();
			System.out.println(listCA.get(i).getCustomerId());
			
			list.add(lArr);
			
		}
		m.addAttribute("list", list);
		return "showbalance";
		
	}

	@RequestMapping(value = "/addCustomerAccount", method = RequestMethod.POST)
	public String addUserAccount(@ModelAttribute("acc") CustomerAccount acc, Model m, HttpServletResponse response) {
		
		//Login l = new Login();

		if (dao1.addAccount(acc,"0") != -1) {
			
			System.out.println("The customerid is : "+acc.getCustomerId());

			Customer l = dao1.getLoginId(acc.getCustomerId());
			System.out.print("The LoginId received is "+l.getLoginId());
			
			List<CustomerAccount> listCA = dao1.getAllBalance(l.getLoginId());
			ArrayList<String[]> list = new ArrayList<String[]>() ;
//			List<String> list[] = new List<String>[listCA.size()];
//			System.out.println(list.get(0)+"  list==============================");
			for(int i = 0; i < listCA.size();i++) {
				String[] lArr = new String[4];
				lArr[0] = listCA.get(i).getAcctNo();
				System.out.println(listCA.get(i).getAcctNo());
				
				lArr[1] = listCA.get(i).getAcctType();
				System.out.println(listCA.get(i).getAcctType());
				
				lArr[2] = listCA.get(i).getAcctBalance();
				System.out.println(listCA.get(i).getAcctBalance());
				
				lArr[3] = listCA.get(i).getCustomerId();
				System.out.println(listCA.get(i).getCustomerId());
				
				list.add(lArr);
				
			}
			m.addAttribute("list", list);
			return "showbalance";
			
			

//			return "redirect:/showBalance";
		}
		m.addAttribute("message", "Invalid Details!");
		return "redirect:/";
	}
	@RequestMapping("/deposit")
	public String showDepositForm(Model m) {
		m.addAttribute("command", new Bill());
		return "depositmoney";
	}
	@RequestMapping(value = "/depositProcess", method = RequestMethod.POST)
	public String processDeposit( Model m, @RequestParam String BillerName,
			@RequestParam String BillerAcctNo, @RequestParam String Amt, @RequestParam String CustomerId, HttpServletResponse response) {

		if (dao1.depositMoney( BillerName, BillerAcctNo, Amt, CustomerId) != -1) {

			return "redirect:/";
		}
		m.addAttribute("message", "Invalid Details!");
		return "/";
	}
	
	//withdrawMoney
	@RequestMapping("/withdraw")
	public String showWithdrawForm(Model m) {
		m.addAttribute("command", new Bill());
		return "drawmoney";
	}
	@RequestMapping(value = "/withdrawProcess", method = RequestMethod.POST)
	public String processWithdraw( Model m, @RequestParam String BillerName,
			@RequestParam String BillerAcctNo, @RequestParam String Amt, @RequestParam String CustomerId, HttpServletResponse response) {

		if (dao1.withdrawMoney( BillerName, BillerAcctNo, Amt, CustomerId) != -1) {

			return "redirect:/";
		}
		m.addAttribute("message", "Invalid Details!");
		return "/";
	}
	@RequestMapping("/transfer")
	public String showTransferForm(Model m) {
		
		return "transfermoney";
	}
	@RequestMapping(value = "/transferProcess", method = RequestMethod.POST)
	public String processWithdraw(@ModelAttribute("acc") CustomerAccount acc, Model m,@RequestParam String amount,@RequestParam String accWithdraw,@RequestParam String accDeposit, HttpServletResponse response) {

		if (dao1.transferMoney(acc,amount,accWithdraw,accDeposit) != -1) {

			return "redirect:/";
		}
		m.addAttribute("message", "Invalid Details!");
		return "/";
	}
}
