package com.eugene.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eugene.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create the query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		// get the list of customers from the query
		List<Customer> customers = query.getResultList();

		// return the list of customers
		return customers;
	}

	@Override
	public void addCustomer(Customer c) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(c);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Customer.class, id));
	}

}
