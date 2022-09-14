package com.Gokul.ItemService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gokul.ItemService.datamodel.Item;
import com.Gokul.ItemService.dto.ItemDTO;
import com.Gokul.ItemService.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired(required = false)
	private ModelMapper modelMapper;

	public List<ItemDTO> all() {
		return itemRepository.findAll().stream().map(item -> modelMapper.map(item, ItemDTO.class))
				.collect(Collectors.toList());
	}

	public ItemDTO save(ItemDTO itemDTO) {
		Item customer = itemRepository.save(modelMapper.map(itemDTO, Item.class));
		return modelMapper.map(customer, ItemDTO.class);
	}

	public ItemDTO get(String itemName) {
		return modelMapper.map(itemRepository.findByName(itemName), ItemDTO.class);
	}


}
