package com.example.fridgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityFridge extends Fragment {

	TableLayout tableLayout;
	Button add_item_button;
	
	public MainActivityFridge() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.activity_main_fragment_fridge, container, false);
		tableLayout = (TableLayout) rootView
				.findViewById(R.id.activity_main_fragment_fridge_table);
		add_item_button = (Button) rootView
				.findViewById(R.id.activity_main_fragment_fridge_button1);
		add_item_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				addItemToList("GogogoBobobo", "20", "3 days");
			}
		});
		addItems();
		return rootView;
	}

	public void addItemToList(String name, String quantity, String time) {
		TableRow tableRow = (TableRow) View.inflate(getActivity(),
				R.layout.table_item_row_for_fridge, null);
		TextView productName = (TextView) tableRow.findViewById(R.id.textView1);
		TextView productQuantity = (TextView) tableRow
				.findViewById(R.id.textView2);
		TextView productTimeLeft = (TextView) tableRow.findViewById(R.id.textView3);
		productName.setText(name);
		productQuantity.setText(quantity);
		productTimeLeft.setText(time);
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
		addItemToList("Cabbages","10", "3 days");
		addItemToList("Milk","10", "3 days");
		addItemToList("Eggs","9", "3 days");
		addItemToList("Cucumbers","7", "3 days");
		addItemToList("Tomatoes","6", "3 days");
		addItemToList("Bread","6", "3 days");
		addItemToList("Vodka","5", "3 days");
		addItemToList("Honey","4", "3 days");
	}
}
