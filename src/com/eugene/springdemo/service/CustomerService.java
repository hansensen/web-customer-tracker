package com.eugene.springdemo.service;

import java.util.List;

import com.eugene.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
