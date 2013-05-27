package com.example.fridgeapp.product_classes;

public class Product {
	protected static int calories;
	protected static int proteins;
	protected static int fats;
	protected static int carbohydrates;
	public String surrogates;
	public String duedate;
	public int rating = 1;
	public int quantity = 0;
	public int db_id = 0;
	public Boolean alarm = false;
	
	public Product() {
		carbohydrates = 0;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public int getProteins() {
		return proteins;
	}
	
	public int getFats() {
		return fats;
	}
	
	public int getCarbohydrates() {
		return carbohydrates;
	}
	
	public String getQuantity() {
		return Integer.toString(quantity);
	}
	
	public String getTime() {
		//TODO calculate how much time left based on today's date
		return "2 days";
	}
	
	public String getName() {
		return "Product";
	}
	
	public String getNameUA() {
		return "Продукт";
	}
}
