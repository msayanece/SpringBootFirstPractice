package com.sayan.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sayan.springboot.dao.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testSaveCustomer() {
		Customer customer = createACustomerObject();
		testEntityManager.persist(customer);
		Customer savedCustomer = customerRepository.findById(customer.getId()).get();
		
		assertThat(savedCustomer).isEqualTo(customer);
	}
	
	@Test
	public void testgetAllCustomers() {
		Customer customer1 = createACustomerObject1();
		Customer customer2 = createACustomerObject2();
		Customer customer3 = createACustomerObject3();
		testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);
		testEntityManager.persist(customer3);
		
		Iterable<Customer> savedCustomers = customerRepository.findAll();
		assertThat(savedCustomers).size().isEqualTo(3);
		assertThat(savedCustomers).asList().contains(customer1, customer2, customer3);
	}

	private Customer createACustomerObject() {
		return new Customer(
				"Sayan", 
				"s@g.c", 
				"9876543210", 
				"Test Address", 
				"1990-06-27", 
				"Male", 
				"Birati", 
				"Savings"
				);
	}
	private Customer createACustomerObject1() {
		return new Customer(
				"Sayan1", 
				"s@g.c", 
				"9876543210", 
				"Test Address", 
				"1990-06-27", 
				"Male", 
				"Birati", 
				"Savings1"
				);
	}
	private Customer createACustomerObject2() {
		return new Customer(
				"Sayan2", 
				"s@g.c", 
				"9876543210", 
				"Test Address", 
				"1990-06-27", 
				"Male", 
				"Birati", 
				"Savings2"
				);
	}
	private Customer createACustomerObject3() {
		return new Customer(
				"Sayan3", 
				"s@g.c", 
				"9876543210", 
				"Test Address", 
				"1990-06-27", 
				"Male", 
				"Birati", 
				"Savings3"
				);
	}
}
