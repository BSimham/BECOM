package com.backend.BECOM.DTO;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long userId;
    private List<OrderItemDTO> items = new ArrayList<>();
    private double totalAmount;
    private String shippingAddress;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<OrderItemDTO> getItems() {
		return items;
	}
	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

    // Getters and setters
}

