package com.Gokul.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gokul.customers.dto.CustomerDTO;
import com.Gokul.customers.rabbitmq.RabbitMQSender;
import com.Gokul.customers.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RabbitMQSender Rabbitmqsender;

	@GetMapping("/")
	public List<CustomerDTO> all() {
		return customerService.all();
	}

	@GetMapping("/{id}")
	public CustomerDTO findbyId(@PathVariable int id) {
		return customerService.findOne(id);
	}

	@PostMapping("/create")
	public CustomerDTO add(@RequestBody CustomerDTO customerDTO) {
		CustomerDTO save = customerService.save(customerDTO);
		Rabbitmqsender.send(save);

		return save;
	}


}
