package com.sayan.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sayan.springboot.dao.Customer;
import com.sayan.springboot.dto.CustomerDTO;
import com.sayan.springboot.repository.CustomerRepository;

@Component
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer addNewCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer(customerDTO.getName(), 
						customerDTO.getEmail(), 
						customerDTO.getPhone(), 
						customerDTO.getAddress(), 
						customerDTO.getDob(), 
						customerDTO.getGender(), 
						customerDTO.getBranch(), 
						customerDTO.getBranchType());
		return customerRepository.save(customer);
	}

	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}
}
