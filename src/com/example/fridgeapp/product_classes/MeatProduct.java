package com.example.fridgeapp.product_classes;

public class MeatProduct extends Product{
	
	@Override
	public String getQuantity() {
		return Integer.toString(quantity) + "kg";
	}
}
