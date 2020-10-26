package com.jkn.dao;

import java.util.List;

import com.jkn.model.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers();

	public Customer getCustomer(int id);

	public Customer addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);
}