package com.example.fridgeapp.products;

import com.example.fridgeapp.product_classes.MeatProduct;

public class Veal extends MeatProduct{
	public Veal() {
		carbohydrates = "2";
		proteins = "2";
		calories = "3";
		fats = "4";
	}
	
	@Override
	public String getName() {
		return "Veal";
	}
	
	@Override
	public String getNameUA() {
		return "Телятина";
	}
}
