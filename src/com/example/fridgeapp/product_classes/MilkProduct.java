package com.example.fridgeapp.product_classes;

public class MilkProduct extends Product {
	
	@Override
	public String getQuantity() {
		return Integer.toString(quantity) + "l";
	}
}
