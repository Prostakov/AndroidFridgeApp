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

public class MainActivityShopList extends Fragment {

	TableLayout tl;
	Button new_button;
	
	public MainActivityShopList() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_main_fragment_shoplist, container, false);
		tl = (TableLayout) rootView.findViewById(R.id.activity_main_fragment_shoplist_table);
		new_button = (Button) rootView.findViewById(R.id.activity_main_fragment_shoplist_button1);
		new_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				TableRow tr1 = new TableRow(getActivity());
				tr1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT));
				TextView textview = new TextView(getActivity());
				textview.setText("bebe");
				textview.setTextColor(Color.YELLOW);
				tr1.addView(textview);
				tl.addView(tr1, new TableLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

			}
		});

		return rootView;
	}
}
