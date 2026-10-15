package com.grocery;

public class CartItem {
	
	private Products product;
	private int quantity;
	
//	constructor
	public CartItem(Products product, int quantity) {
		
		this.product = product;
		this.quantity = quantity;
	}
	
//	getters and setters
	public Products getProduct() {
		return product;
	}
	
	public void setProduct(Products product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
