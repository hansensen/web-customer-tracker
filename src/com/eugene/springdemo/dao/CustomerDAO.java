package com.eugene.springdemo.dao;

import java.util.List;

import com.eugene.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void addCustomer(Customer c);

}
