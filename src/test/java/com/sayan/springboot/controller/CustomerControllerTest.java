package com.sayan.springboot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sayan.springboot.dao.Customer;
import com.sayan.springboot.dto.CustomerDTO;
import com.sayan.springboot.service.CustomerService;

import static org.mockito.ArgumentMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	CustomerService customerService;
	
	@Test
	public void testAddCustomer() throws UnsupportedEncodingException, Exception {
		CustomerDTO createACustomerDTOObject = createACustomerDTOObject();
		Customer createACustomerObject = createACustomerObject();
//		String req = "name=Sayan&email=s%40g.c&phone=9876543210&address=Test+Address&dob=1990-06-27&gender=male&branch=birati&branchType=Savings&tnc=on";
		String convertToJSONString = convertToJSONString(createACustomerObject);
		String reqJSONString = convertToJSONString(createACustomerDTOObject);
		when(customerService.addNewCustomer(any(CustomerDTO.class))).thenReturn(createACustomerObject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
		.post("/api/customer/save")
		.characterEncoding("utf-8")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.content(reqJSONString);
//		.contentType(MediaType.APPLICATION_JSON);
		
		String responseAsString = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();
		
		assertThat(responseAsString).isEqualTo(convertToJSONString);
	}
	
	@Test
	public void testGetAllCustomers() throws UnsupportedEncodingException, Exception {
		Customer customer = createACustomerObject();
		Customer customer2 = createACustomerObject();
		Customer customer3 = createACustomerObject();
		Customer customer4 = createACustomerObject();
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		
		String expectedResponse = convertToJSONString(customers);
		when(customerService.findAll()).thenReturn(customers);
		
		RequestBuilder request = MockMvcRequestBuilders
		.get("/api/customer/all");
		String contentAsString = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
		
		assertThat(contentAsString).isEqualTo(expectedResponse);
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
	
	private String convertToJSONString(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
