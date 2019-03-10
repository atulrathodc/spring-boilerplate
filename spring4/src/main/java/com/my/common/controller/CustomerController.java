package com.my.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.common.dao.EmployeeDAO;
import com.my.common.model.Employee;



@Controller
public class CustomerController {
	
	@Autowired
	EmployeeDAO emdao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);
	
	private Map<String, Customer> customers = null;
	
	public CustomerController(){
		customers = new HashMap<String, Customer>();
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String saveEmployeePage(Model model) {
		logger.info("Returning emloyeesave.jsp page");
		model.addAttribute("employee", new Employee());
		return "employeeSave";
	}
	
	
	@RequestMapping(value = "/saveact", method = RequestMethod.POST)
	public String saveCustomerAction1(
			@Valid @ModelAttribute("employee")Employee em,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning employeeSave.jsp page");
			return "employeeSave";
		}
		System.out.println(em);
		  emdao.save(em);
		logger.info("Returning employeeSaveSuccess.jsp page");
		
		//model.addAttribute("customer", em);
	
		return "employeeSave";
	}

	
	@RequestMapping(value = "/cust/save", method = RequestMethod.GET)
	public String saveCustomerPage(Model model) {
		logger.info("Returning custSave.jsp page");
		model.addAttribute("customer", new Customer());
		return "custSave";
	}

	@RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
	public String saveCustomerAction(
			@Valid Customer customer,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning custSave.jsp page");
			return "custSave";
		}
		logger.info("Returning custSaveSuccess.jsp page");
		model.addAttribute("customer", customer);
		customers.put(customer.getEmail(), customer);
		return "custSaveSuccess";
	}

}
