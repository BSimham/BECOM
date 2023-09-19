package com.backend.BECOM.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order")
    private java.util.List<OrderItem> items = new ArrayList<>();

    private double totalAmount;
    private String shippingAddress;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User usrId) {
		this.user = usrId;
	}
	public java.util.List<OrderItem> getItems() {
		return items;
	}
	public void setItems(java.util.List<OrderItem> items) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order() {
		
	}
	public Order(Long id, User usrId, List<OrderItem> items, double totalAmount, String shippingAddress, String status) {
		super();
		this.id = id;
		this.user = usrId;
		this.items = items;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.status = status;
	} 

    
}
