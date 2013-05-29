package com.example.fridgeapp.product_classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Product {
	protected static int calories;
	protected static int proteins;
	protected static int fats;
	protected static int carbohydrates;
	public String surrogates;
	public String duedate;
	public String time;
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
	
	public String getDaysLeft() {
		Date endDate = parseDate(duedate);
		Date curDate = parseDate(giveCurrentDate());
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(curDate);
	    Calendar cal2 = Calendar.getInstance();
	    cal2.setTime(endDate);
	    long daysLeft = daysBetween(cal1, cal2);
	    if (daysLeft == 1) return "1 day";
	    else return Long.toString(daysLeft) + " days";
	}
	
	public String getName() {
		return "Product";
	}
	
	public String getNameUA() {
		return "Продукт";
	}
	
	private Date parseDate(String dateString) {
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    try {
	    	Date endDate =  df.parse(dateString);
		    return endDate;
	    } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String giveCurrentDate()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(cal.getTime());
    }
	
	private long daysBetween(Calendar startDate, Calendar endDate) {
        Calendar date = (Calendar) startDate.clone();
        long daysBetween = 0;
        while (date.before(endDate)) {
            date.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }
}