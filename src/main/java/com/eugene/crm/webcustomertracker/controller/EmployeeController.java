package com.eugene.crm.webcustomertracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee e) {
		employeeService.save(e);
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		// create model attribute to bind form data
		Employee e = employeeService.findById(id);
		model.addAttribute("employee", e);
		return "employees/employee-form";
	}

	@GetMapping("/deleteById")
	public String deleteById(@RequestParam("employeeId") int id, Model model) {
		// create model attribute to bind form data
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}

}
