package com.groupd.finalproject.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupd.finalproject.bean.Bill;
import com.groupd.finalproject.bean.Customer;
import com.groupd.finalproject.bean.CustomerAccount;
import com.groupd.finalproject.bean.Login;
import com.groupd.finalproject.dao.CustomerAccountDao;
import com.groupd.finalproject.dao.CustomerDao;
import com.groupd.finalproject.dao.LoginDao;


@Controller
public class LoginController {

	@Autowired
	LoginDao dao3;	
	
	@Autowired
	CustomerAccountDao dao1;

	@RequestMapping("/")
	public String showLoginForm(Model m) {
		m.addAttribute("login", new Login());
		return "login";
	}
	
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(Model m) {
		m.addAttribute("command", new Login());
		return "register";
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String processRegister(@ModelAttribute("login") Login login, Model m, HttpServletResponse response) {

		// validate the user and redirect to welcome page
		if (dao3.registerUser(login) != -1) {

			return "redirect:/custform";
			//return "CustomerForm";
		}
		// Otherwise show error message
		m.addAttribute("message", "Please try another LoginId and Password!");
		return "login";
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("login") Login login, Model m, HttpServletResponse response) {

		if (dao3.validateUser(login) != null) {

			System.out.println(login.getLoginId());
			List<CustomerAccount> listCA = dao1.getAllBalance(login.getLoginId());
			ArrayList<String[]> list = new ArrayList<String[]>() ;
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
		// Otherwise show error message
		m.addAttribute("message", "Invalid LoginId or password!");
		return "login";
	}
}

