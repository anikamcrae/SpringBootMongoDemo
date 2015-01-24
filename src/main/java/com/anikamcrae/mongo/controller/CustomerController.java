package com.anikamcrae.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anikamcrae.mongo.domain.Customer;
import com.anikamcrae.mongo.repository.CustomerRepository;

@RestController
@RequestMapping("customers")
public class CustomerController {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CustomerRepository repo;
	

	// localhost:8080/customers/name?firstName=Alice
	@RequestMapping(value="/name", method = RequestMethod.GET)
	public Customer getCustomer(@RequestParam("firstName") String firstName) {
		log.info("Controller getCustomer");		
		return repo.findByFirstName(firstName);
	}
	

	// localhost:8080/customers	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> findAllCustomers() {
		log.info("Controller findAllCustomers");
		return repo.findAll();
	}
}
