package com.example.fridgeapp;

import com.example.fridgeapp.db_adapters.DBFridgeAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AlarmActivity extends Activity {
	
	DBFridgeAdapter db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		db = new DBFridgeAdapter(this);
		Intent intent = getIntent();
		String productName = intent.getStringExtra("name");
		TextView str = (TextView) findViewById(R.id.textView1);
		str.setText(productName);
		db.open();
		db.switchOffAlarm(db.findRecord(productName));
		db.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}

}
