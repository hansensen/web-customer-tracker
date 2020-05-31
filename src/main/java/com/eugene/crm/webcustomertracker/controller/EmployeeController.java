package com.eugene.crm.webcustomertracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eugene.crm.webcustomertracker.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	@Autowired
	private EmployeeService employeeService;

	// ad mapping for /list
	@GetMapping("/list")
	private String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "list-employees";
	}

}
