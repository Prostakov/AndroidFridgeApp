package com.example.fridgeapp;

import com.example.fridgeapp.db_adapters.DBFridgeAdapter;
import com.example.fridgeapp.product_classes.Product;
import com.example.fridgeapp.products.Ananas;
import com.example.fridgeapp.products.Apple;
import com.example.fridgeapp.products.Banana;
import com.example.fridgeapp.products.Beef;
import com.example.fridgeapp.products.Bread;
import com.example.fridgeapp.products.Carassius;
import com.example.fridgeapp.products.Carrot;
import com.example.fridgeapp.products.Chicken;
import com.example.fridgeapp.products.ChickenEggs;
import com.example.fridgeapp.products.Cola;
import com.example.fridgeapp.products.Cucumber;
import com.example.fridgeapp.products.Esox;
import com.example.fridgeapp.products.Juice;
import com.example.fridgeapp.products.Ketchup;
import com.example.fridgeapp.products.Lemon;
import com.example.fridgeapp.products.Mayonnaise;
import com.example.fridgeapp.products.Milk;
import com.example.fridgeapp.products.Mineral;
import com.example.fridgeapp.products.Mustard;
import com.example.fridgeapp.products.Orange;
import com.example.fridgeapp.products.Perch;
import com.example.fridgeapp.products.Pork;
import com.example.fridgeapp.products.SourCream;
import com.example.fridgeapp.products.Tomato;
import com.example.fridgeapp.products.Veal;
import com.example.fridgeapp.products.Yoghurt;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Toast;

public class ViewProductPropActivity extends Activity {

	DBFridgeAdapter db;
	Product product;
	Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_product_prop);
		db = new DBFridgeAdapter(context);
		Intent intent = getIntent();
		String productName = intent.getStringExtra("productName");
		if (productName == null) return;
		product = initProduct(Product.getProductNameEN(productName));
		Toast.makeText( this, product.getNameUA(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_product_prop, menu);
		return true;
	}
	
	private Product initProduct(String name) {
		db.open();
		Cursor c = db.getRecord(db.findRecord(name));
		db.close();
		if (c.moveToFirst()) {
			do {
				if (c.getString(1).equalsIgnoreCase("Ananas")) {
					Ananas ananas = new Ananas();
					ananas.db_id = Integer.parseInt(c.getString(0));
					ananas.surrogates = c.getString(4);
					return ananas;
				} else if (c.getString(1).equalsIgnoreCase("Apple")) {
					Apple apple = new Apple();
					apple.db_id = Integer.parseInt(c.getString(0));
					apple.surrogates = c.getString(4);
					return apple;
				} else if (c.getString(1).equalsIgnoreCase("Banana")) {
					Banana banana = new Banana();
					banana.db_id = Integer.parseInt(c.getString(0));
					banana.surrogates = c.getString(4);
					return banana;
				} else if (c.getString(1).equalsIgnoreCase("Beef")) {
					Beef beef = new Beef();
					beef.db_id = Integer.parseInt(c.getString(0));
					beef.surrogates = c.getString(4);
					return beef;
				} else if (c.getString(1).equalsIgnoreCase("Bread")) {
					Bread bread = new Bread();
					bread.db_id = Integer.parseInt(c.getString(0));
					bread.surrogates = c.getString(4);
					return bread;
				} else if (c.getString(1).equalsIgnoreCase("Carassius")) {
					Carassius carassius = new Carassius();
					carassius.db_id = Integer.parseInt(c.getString(0));
					carassius.surrogates = c.getString(4);
					return carassius;
				} else if (c.getString(1).equalsIgnoreCase("Carrot")) {
					Carrot carrot = new Carrot();
					carrot.db_id = Integer.parseInt(c.getString(0));
					carrot.surrogates = c.getString(4);
					return carrot;
				} else if (c.getString(1).equalsIgnoreCase("Chicken")) {
					Chicken chicken = new Chicken();
					chicken.db_id = Integer.parseInt(c.getString(0));
					chicken.surrogates = c.getString(4);
					return chicken;
				} else if (c.getString(1).equalsIgnoreCase("ChickenEggs")) {
					ChickenEggs chickenEggs = new ChickenEggs();
					chickenEggs.db_id = Integer.parseInt(c.getString(0));
					chickenEggs.surrogates = c.getString(4);
					return chickenEggs;
				} else if (c.getString(1).equalsIgnoreCase("Cola")) {
					Cola cola = new Cola();
					cola.db_id = Integer.parseInt(c.getString(0));
					cola.surrogates = c.getString(4);
					return cola;
				} else if (c.getString(1).equalsIgnoreCase("Cucumber")) {
					Cucumber cucumber = new Cucumber();
					cucumber.db_id = Integer.parseInt(c.getString(0));
					cucumber.surrogates = c.getString(4);
					return cucumber;
				} else if (c.getString(1).equalsIgnoreCase("Esox")) {
					Esox esox = new Esox();
					esox.db_id = Integer.parseInt(c.getString(0));
					esox.surrogates = c.getString(4);
					return esox;
				} else if (c.getString(1).equalsIgnoreCase("Juice")) {
					Juice juice = new Juice();
					juice.db_id = Integer.parseInt(c.getString(0));
					juice.surrogates = c.getString(4);
					return juice;
				} else if (c.getString(1).equalsIgnoreCase("Ketchup")) {
					Ketchup ketchup = new Ketchup();
					ketchup.db_id = Integer.parseInt(c.getString(0));
					ketchup.surrogates = c.getString(4);
					return ketchup;
				} else if (c.getString(1).equalsIgnoreCase("Lemon")) {
					Lemon lemon = new Lemon();
					lemon.db_id = Integer.parseInt(c.getString(0));
					lemon.surrogates = c.getString(4);
					return lemon;
				} else if (c.getString(1).equalsIgnoreCase("Mayonnaise")) {
					Mayonnaise mayonnaise = new Mayonnaise();
					mayonnaise.db_id = Integer.parseInt(c.getString(0));
					mayonnaise.surrogates = c.getString(4);
					return mayonnaise;
				} else if (c.getString(1).equalsIgnoreCase("Milk")) {
					Milk milk = new Milk();
					milk.db_id = Integer.parseInt(c.getString(0));
					milk.surrogates = c.getString(4);
					return milk;
				} else if (c.getString(1).equalsIgnoreCase("Mineral")) {
					Mineral mineral = new Mineral();
					mineral.db_id = Integer.parseInt(c.getString(0));
					mineral.surrogates = c.getString(4);
					return mineral;
				} else if (c.getString(1).equalsIgnoreCase("Mustard")) {
					Mustard mustard = new Mustard();
					mustard.db_id = Integer.parseInt(c.getString(0));
					mustard.surrogates = c.getString(4);
					return mustard;
				} else if (c.getString(1).equalsIgnoreCase("Orange")) {
					Orange orange = new Orange();
					orange.db_id = Integer.parseInt(c.getString(0));
					orange.surrogates = c.getString(4);
					return orange;
				} else if (c.getString(1).equalsIgnoreCase("Perch")) {
					Perch perch = new Perch();
					perch.db_id = Integer.parseInt(c.getString(0));
					perch.surrogates = c.getString(4);
					return perch;
				} else if (c.getString(1).equalsIgnoreCase("Pork")) {
					Pork pork = new Pork();
					pork.db_id = Integer.parseInt(c.getString(0));
					pork.surrogates = c.getString(4);
					return pork;
				} else if (c.getString(1).equalsIgnoreCase("SourCream")) {
					SourCream sourCream = new SourCream();
					sourCream.db_id = Integer.parseInt(c.getString(0));
					sourCream.surrogates = c.getString(4);
					return sourCream;
				} else if (c.getString(1).equalsIgnoreCase("Tomato")) {
					Tomato tomato = new Tomato();
					tomato.db_id = Integer.parseInt(c.getString(0));
					tomato.surrogates = c.getString(4);
					return tomato;
				} else if (c.getString(1).equalsIgnoreCase("Veal")) {
					Veal veal = new Veal();
					veal.db_id = Integer.parseInt(c.getString(0));
					veal.surrogates = c.getString(4);
					return veal;
				} else if (c.getString(1).equalsIgnoreCase("Yoghurt")) {
					Yoghurt yoghurt = new Yoghurt();
					yoghurt.db_id = Integer.parseInt(c.getString(0));
					yoghurt.surrogates = c.getString(4);
					return yoghurt;
				}
			} while (c.moveToNext());
		}
		return new Product();
	}

}
