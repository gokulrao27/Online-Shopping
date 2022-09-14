package com.Gokul.ItemService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gokul.ItemService.dto.ItemDTO;
import com.Gokul.ItemService.service.ItemService;

@RequestMapping("/items")
@RestController
public class ItemResource {

	@Autowired
	private ItemService itemService;

	@GetMapping("/")
	public List<ItemDTO> all() {
		return itemService.all();
	}

	@GetMapping("/{itemName}")
	public ItemDTO get(@PathVariable String itemName) {
		return itemService.get(itemName);
	}

	@PostMapping("/create")
	public ItemDTO add(@RequestBody ItemDTO itemDTO) {
		return itemService.save(itemDTO);
	}




}
