package com.Gokul.salesorderservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gokul.salesorderservice.dto.SalesOrderDTO;
import com.Gokul.salesorderservice.service.SalesOrderService;

@RequestMapping("/orders")
@RestController
public class SalesOrderResource {

	@Autowired
	private SalesOrderService salesOrderService;

	@GetMapping("/")
	public List<SalesOrderDTO> all() {
		return salesOrderService.all();
	}

	@GetMapping("/{id}")
	public SalesOrderDTO get(@PathVariable long id) {
		return salesOrderService.get(id);
	}

	@PostMapping("/")
	public SalesOrderDTO add(@RequestBody SalesOrderDTO salesOrderDTO) {
		return salesOrderService.save(salesOrderDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		salesOrderService.delete(id);
	}

}
