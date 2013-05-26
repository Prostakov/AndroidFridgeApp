package com.example.fridgeapp.product_classes;

public class FishProduct extends Product {
	
	@Override
	public String getQuantity() {
		return Integer.toString(quantity) + "kg";
	}
}
