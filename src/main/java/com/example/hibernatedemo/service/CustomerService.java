package com.example.hibernatedemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernatedemo.dao.CustomerDao;
import com.example.hibernatedemo.model.Customer;

@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Transactional
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);

	}

	@Transactional
	public String deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}
}
