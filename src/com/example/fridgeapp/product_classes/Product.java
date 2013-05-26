package com.example.fridgeapp.product_classes;

public class Product {
	private static final int calories = 0;
	private static final int proteins = 0;
	private static final int fats = 0;
	private static final int carbohydrates = 0;
	public String surrogates;
	public String duedate;
	public int rating = 1;
	public int quantity = 0;
	public Boolean alarm = false; 
	
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
}
