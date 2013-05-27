package com.example.fridgeapp.products;

import com.example.fridgeapp.product_classes.MilkProduct;

public class SourCream extends MilkProduct {
	public SourCream() {
		carbohydrates = 2;
		proteins = 2;
		calories = 3;
		fats = 4;
	}
	
	@Override
	public String getName() {
		return "Sour cream";
	}
	
	@Override
	public String getNameUA() {
		return "Сметана";
	}
}
