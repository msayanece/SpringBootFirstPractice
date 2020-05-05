package com.sayan.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.springboot.dao.Customer;
import com.sayan.springboot.dto.CustomerDTO;
import com.sayan.springboot.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/save")
	public Customer addCustomer(@ModelAttribute @Valid CustomerDTO customer) {
		Customer addedCustomer = customerService.addNewCustomer(customer);
		return addedCustomer;
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Customer> getAllCustomers() {
		// This returns a JSON or XML with the users
		return customerService.findAll();
	}
}
