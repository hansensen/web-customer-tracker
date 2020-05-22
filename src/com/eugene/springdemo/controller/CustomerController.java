package com.eugene.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eugene.springdemo.entity.Customer;
import com.eugene.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the DAO

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		// get the customers from DAO
		List<Customer> customers = customerService.getCustomers();
		// add the customers to the model
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		// customerService.addCustomer(customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer c) {
		customerService.addCustomer(c);
		return "redirect:/customer/list";
	}
}
