package com.backend.BECOM.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "PID")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Long price;
	
	@Column(nullable = false)
	private String imgurl;
	
	@Column(nullable = false)
	private Long quantity;
	
	@Column(nullable = false)
	private String category;
	
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long pid) {
		this.id = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String pname) {
		this.name = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imgurl;
	}
	public void setImgUrl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Product(Long pid, String pname, String description, Long price, String imgurl,Long quantity, String category) {
		super();
		this.id = pid;
		this.name = pname;
		this.description = description;
		this.price = price;
		this.imgurl = imgurl;
		this.quantity = quantity;
		this.category = category;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
}
