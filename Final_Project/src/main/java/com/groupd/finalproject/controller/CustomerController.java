package com.groupd.finalproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.groupd.finalproject.bean.Customer;

import com.groupd.finalproject.dao.CustomerDao;
@Controller
public class CustomerController {

	
	@Autowired
	CustomerDao dao2;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping(value ="/custform", method = RequestMethod.GET)
	public String showform(@ModelAttribute("cust") Customer cust,Model m) {
		m.addAttribute("command", new Customer());
		return "CustomerForm";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("cust") Customer cust,Model m) {
		dao2.save(cust);
		List<Customer> list = dao2.getCustomer(cust);

		m.addAttribute("list", list);
		System.out.print("The customer list is"+list);
		return "CustInfo";
	}
	
	
	@RequestMapping(value = "/editcust/{id}" , method = RequestMethod.GET)
	public String editCustomerForm(@PathVariable("id") int id,@ModelAttribute("cust") Customer cust,Model m) {
		Customer cust1 = dao2.getCustById(Integer.toString(id));
		m.addAttribute("command", cust1);
		return "CustomerEdit";
	}
	
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("cust") Customer cust) {
		dao2.updateCustomer(cust);
		return "CustInfo";
	}
	
	@RequestMapping(value = "/deletecust/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		dao2.deleteCustomer(id);
		return "redirect:/addAccount";
	}

	@RequestMapping(value = "/viewcust",method = RequestMethod.GET )
	public String viewemp(Model m,@ModelAttribute("cust") Customer cust) {
		List<Customer> list = dao2.getCustomer(cust);
		m.addAttribute("list", list);
		System.out.print("The customer list is"+list);
		return "CustInfo";
	}
}
