package com.example.fridgeapp.products;

import com.example.fridgeapp.product_classes.MilkProduct;

public class Milk extends MilkProduct {
	public Milk() {
		carbohydrates = "2";
		proteins = "2";
		calories = "3";
		fats = "4";
	}
	
	@Override
	public String getCaloriesTitle() {
		return "Calories/100ml:";
	}
	
	@Override
	public String getCarbohydratesTitle() {
		return "Carbohydrates/100ml:";
	}
	
	@Override
	public String getProteinsTitle() {
		return "Proteins/100ml:";
	}
	
	@Override
	public String getFatsTitle() {
		return "Fats/100ml:";
	}
	
	@Override
	public String getName() {
		return "Milk";
	}
	
	@Override
	public String getNameUA() {
		return "������";
	}
}
