package com.eugene.crm.webcustomertracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eugene.crm.webcustomertracker.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
