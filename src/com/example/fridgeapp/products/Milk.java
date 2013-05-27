package com.example.fridgeapp.products;

import com.example.fridgeapp.product_classes.MilkProduct;

public class Milk extends MilkProduct {
	public Milk() {
		carbohydrates = 2;
		proteins = 2;
		calories = 3;
		fats = 4;
	}
	
	@Override
	public String getName() {
		return "Milk";
	}
	
	@Override
	public String getNameUA() {
		return "Молоко";
	}
}
