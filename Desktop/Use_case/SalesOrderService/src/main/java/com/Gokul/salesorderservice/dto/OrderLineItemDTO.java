package com.Gokul.salesorderservice.dto;

public class OrderLineItemDTO {

	private long id;
	private String name;
	private long itemQuantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return name;
	}

	public void setItemName(String itemName) {
		this.name = itemName;
	}

	public long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
}
