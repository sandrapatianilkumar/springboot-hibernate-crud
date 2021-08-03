package com.example.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernatedemo.model.Customer;
import com.example.hibernatedemo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer customerResp = new Customer();
		if (customer.getId() == 0) {
			customerResp = customerService.addCustomer(customer);
		} else {
			customerResp = customerService.updateCustomer(customer);
		}

		return customerResp;
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer customerResp = new Customer();
		customerResp = customerService.updateCustomer(customer);
		return customerResp;
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getAllCustomers() {

		List<Customer> listOfCustomers = customerService.getAllCustomers();

		return listOfCustomers;
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		return customerService.deleteCustomer(id);
	}
}