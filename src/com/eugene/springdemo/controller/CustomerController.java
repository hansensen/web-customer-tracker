package com.eugene.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eugene.springdemo.dao.CustomerDAO;
import com.eugene.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the DAO

	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model model) {

		// get the customers from DAO
		List<Customer> customers = customerDAO.getCustomers();
		// add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}
}
