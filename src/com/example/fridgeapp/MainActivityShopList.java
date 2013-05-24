package com.example.fridgeapp;

import com.example.fridgeapp.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityShopList extends Fragment {

	TableLayout tableLayout;
	Button add_item_button;

	public MainActivityShopList() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.activity_main_fragment_shoplist, container, false);
		tableLayout = (TableLayout) rootView
				.findViewById(R.id.activity_main_fragment_shoplist_table);
		add_item_button = (Button) rootView
				.findViewById(R.id.activity_main_fragment_shoplist_button1);
		add_item_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				addItemToList("GogogoBobobo", "20");
			}
		});
		addItems();
		return rootView;
	}

	public void addItemToList(String name, String rating) {
		TableRow tableRow = (TableRow) View.inflate(getActivity(),
				R.layout.table_item_row_for_shoplist, null);
		TextView productName = (TextView) tableRow.findViewById(R.id.textView1);
		TextView productRating = (TextView) tableRow
				.findViewById(R.id.textView2);
		productName.setText(name);
		productRating.setText(rating);
		tableLayout.addView(tableRow);
		tableRow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast toast = Toast.makeText(getActivity(), "Clicked!", 5);
				toast.show();
			};
		});
	}
	
	public void addItems() {
		addItemToList("Cabbages","10");
		addItemToList("Milk","10");
		addItemToList("Eggs","9");
		addItemToList("Cucumbers","7");
		addItemToList("Tomatoes","6");
		addItemToList("Bread","6");
		addItemToList("Vodka","5");
		addItemToList("Honey","4");
	}
}
