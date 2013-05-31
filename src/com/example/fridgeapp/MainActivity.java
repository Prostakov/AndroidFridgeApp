package com.example.fridgeapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fridgeapp.db_adapters.DBSettingsAdapter;
import com.example.fridgeapp.db_adapters.DBFridgeAdapter;
import com.example.fridgeapp.db_adapters.DBShopListAdapter;
import com.example.fridgeapp.product_classes.Product;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	SectionsPagerAdapter mSectionsPagerAdapter;

	ViewPager mViewPager;

	@Override
	protected void onResume() {
		super.onResume();
		Intent intent = getIntent();
		String changeTab = intent.getStringExtra("changeTab");
		if (changeTab != null) {
			if (changeTab.equalsIgnoreCase("2")) {
				 mViewPager.setCurrentItem(1);
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.activity_main);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}

		// checking SettingsDB
		try {
			String destPath = "/data/data/" + getPackageName()
					+ "/databases/SettingsDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("mydb"),
						new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// checking ShopListDB
		try {
			String destPath = "/data/data/" + getPackageName()
					+ "/databases/ShopListDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("mydb"),
						new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// this.deleteDatabase("FridgeDB");

		// checking FridgeDB
		try {
			String destPath = "/data/data/" + getPackageName()
					+ "/databases/FridgeDB";
			File f = new File(destPath);
			if (!f.exists()) {
				CopyDB(getBaseContext().getAssets().open("mydb"),
						new FileOutputStream(destPath));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// DBFridgeAdapter db = new DBFridgeAdapter(this);
		// DBShopListAdapter db = new DBShopListAdapter(this);

		// db.open();
		// String recordId = db.findRecord("Pork");
		// db.close();

		// ---add some records to shoplist---

		// db.open();
		// long id = db.insertRecord("Cucumber", 10);
		// id = db.insertRecord("Beef", 5);
		// id = db.insertRecord("Chicken", 3);
		// id = db.insertRecord("ChickenEggs", 2);
		// id = db.insertRecord("Tomato", 9);
		// id = db.insertRecord("Pork", 6);
		// db.close();

		// ---add some records to fridge---

		// db.open();
		// long id = db.insertRecord("Ananas", "3/06/2013", "11:06", "ï³ï³", 4,
		// 0);
		// id = db.insertRecord("Beef", "11/06/2013", "11:06", "ï³ï³", 12, 0);
		// id = db.insertRecord("Chicken", "11/06/2013", "11:06", "ï³ï³", 25,
		// 0);
		// id = db.insertRecord("ChickenEggs", "11/06/2013", "11:06", "ï³ï³",
		// 40, 0);
		// id = db.insertRecord("Tomato", "11/06/2013", "11:06", "ï³ï³", 52, 0);
		// id = db.insertRecord("Pork", "11/06/2013", "11:06", "ï³ï³", 42, 0);
		// db.close();

		// ---get all Records---
		// db.open();
		// Cursor c = db.getAllRecords();
		// if (c.moveToFirst())
		// {
		// do {
		// DisplayRecord(c);
		// } while (c.moveToNext());
		// }
		// db.close();

		// db.open();
		// for (long i = 7; i < 13; i++) {
		// db.deleteContact(i);
		// }
		// db.close();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public MainActivityFridge fragment_fridge;
		public MainActivityShopList fragment_list;

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
			fragment_fridge = new MainActivityFridge();
			fragment_list = new MainActivityShopList();
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0: {
				return fragment_fridge;
			}
			case 1: {
				return fragment_list;
			}
			}
			return null;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}

		@Override
		public int getCount() {
			return 2;
		}
	}

	public void CopyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// ---copy 1K bytes at a time---
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}

	public void DisplayRecord(Cursor c) {
		Toast.makeText(
				this,
				"0:" + c.getString(0) + "\n" + "1:" + c.getString(1) + "\n"
						+ "2:" + c.getString(2) + "\n" + "3:" + c.getString(3)
						+ "\n" + "4:" + c.getString(4) + "\n" + "5:"
						+ c.getString(5) + "\n" + "6:" + c.getString(6) + "\n",
				Toast.LENGTH_SHORT).show();
	}
	public void DisplayToast(String msg) {
		Toast.makeText( this, msg, Toast.LENGTH_SHORT).show();
	}
}
