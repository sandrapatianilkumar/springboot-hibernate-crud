package com.example.hibernatedemo.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernatedemo.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	public Customer getCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;
	}

	public Customer addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(customer);
		return customer;
	}

	public Customer updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(customer);
		session.update(customer);
		return customer;
	}

	public String deleteCustomer(int id) {
		String msg = null;
		Session session = this.sessionFactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
			msg = "Successfully deleted the customer with ID: " + id;
		}
		return msg;
	}
}
