package com.eugene.crm.webcustomertracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eugene.crm.webcustomertracker.entity.Employee;
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
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		// create model attribute to bind form data
		Employee e = new Employee();
		model.addAttribute("employee", e);
		return "employees/employee-form";
	}

}
