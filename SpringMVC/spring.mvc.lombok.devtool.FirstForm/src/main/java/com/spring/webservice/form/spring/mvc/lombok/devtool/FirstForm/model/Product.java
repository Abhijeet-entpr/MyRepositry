package com.spring.webservice.form.spring.mvc.lombok.devtool.FirstForm.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

//@Data
@Entity
public class Product {
	@Id
	private long productId;
	private String productName;
	private Double productPrice;
	public Product() {
		
	}
	
	public Product(long productId, String productName, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
	
	
}
