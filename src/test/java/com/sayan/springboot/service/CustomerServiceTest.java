package com.sayan.springboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sayan.springboot.dao.Customer;
import com.sayan.springboot.dto.CustomerDTO;
import com.sayan.springboot.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@Test
	public void addNewCustomerTest() {
		Customer customer = createACustomerObject();
		CustomerDTO customerDTO = createACustomerDTOObject();
		when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerService.addNewCustomer(customerDTO)).isEqualTo(customer);
	}
	
	@Test
	public void getAllCustomersTest() {
		Customer customer = createACustomerObject();
		Customer customer2 = createACustomerObject();
		Customer customer3 = createACustomerObject();
		Customer customer4 = createACustomerObject();
		when(customerRepository.findAll()).thenReturn(Arrays.asList(customer, customer2, customer3, customer4));
		assertThat(customerService.findAll()).size().isEqualTo(4);
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
	
	private CustomerDTO createACustomerDTOObject() {
		return new CustomerDTO(
				"Sayan", 
				"s@g.c", 
				"9876543210", 
				"Test Address", 
				"1990-06-27", 
				"Male", 
				"Birati", 
				"Savings",
				"on"
				);
	}
}
