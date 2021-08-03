package com.example.hibernatedemo.dao;

import java.util.List;

import com.example.hibernatedemo.model.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers();

	public Customer getCustomer(int id);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public String deleteCustomer(int id);
}
