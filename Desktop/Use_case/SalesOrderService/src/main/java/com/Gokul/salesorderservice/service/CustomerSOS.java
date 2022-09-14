package com.Gokul.salesorderservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gokul.salesorderservice.datamodel.Customer;
import com.Gokul.salesorderservice.dto.CustomerDTO;
import com.Gokul.salesorderservice.repository.CustomerSORepository;

@Service
public class CustomerSOS {

	@Autowired
	private CustomerSORepository customersorepository;

	@Autowired(required = false)
	private ModelMapper modelmapper;

	public CustomerDTO save(CustomerDTO customerDTO) {
		Customer customer = customersorepository.save(modelmapper.map(customerDTO, Customer.class));
		CustomerDTO result = modelmapper.map(customer, CustomerDTO.class);
		return result;
	}

}
