package com.eugene.crm.webcustomertracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eugene.crm.webcustomertracker.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();
}
