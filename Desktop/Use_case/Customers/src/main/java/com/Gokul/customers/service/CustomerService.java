package com.Gokul.customers.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gokul.customers.datamodel.Customers;
import com.Gokul.customers.dto.CustomerDTO;
import com.Gokul.customers.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired(required = false)
	private ModelMapper modelMapper;

	public List<CustomerDTO> all() {
		return customerRepository.findAll().stream().map(c -> modelMapper.map(c, CustomerDTO.class))
				.collect(Collectors.toList());
	}

	public CustomerDTO save(CustomerDTO customerDTO) {
		Customers customer = customerRepository.save(modelMapper.map(customerDTO, Customers.class));
		CustomerDTO result = modelMapper.map(customer, CustomerDTO.class);
		return result;
	}

	public CustomerDTO findOne(int id) {
		Optional<Customers> customerResult = customerRepository.findById((long) id);
		if (!customerResult.isPresent()) {
			return null;
		}
		return modelMapper.map(customerResult.get(), CustomerDTO.class);
	}

}
