package com.sayan.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.sayan.springboot.dao.Customer;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	public Customer findByName(String name);
}