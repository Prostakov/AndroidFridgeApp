package com.example.fridgeapp.product_classes;

import java.util.ArrayList;

public class Beverage extends Product {
	
	public static ArrayList getProductsUA() {
		ArrayList<String> resultArray = new ArrayList<String>();
		resultArray.add("̳�������");
		resultArray.add("ѳ�");
		resultArray.add("����");
		return resultArray;
	}
	
	public static ArrayList getProducts() {
		ArrayList<String> resultArray = new ArrayList<String>();
		resultArray.add("Mineral");
		resultArray.add("Juice");
		resultArray.add("Cola");
		return resultArray;
	}
}