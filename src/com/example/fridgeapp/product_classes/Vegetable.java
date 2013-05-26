package com.example.fridgeapp.product_classes;

public class Vegetable extends Product {
	
	@Override
	public String getQuantity() {
		return Integer.toString(quantity) + "kg";
	}
}
