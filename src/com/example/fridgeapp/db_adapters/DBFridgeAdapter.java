package com.example.fridgeapp.db_adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBFridgeAdapter {
    public static final String KEY_ROWID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DUEDATE = "duedate";
    public static final String KEY_SURROGATES = "surrogates";
    public static final String KEY_QUANTITY = "quantity";
    public static final String KEY_ALARM = "alarm";
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "FridgeDB";
    private static final String DATABASE_TABLE = "fridge";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE =
        "create table if not exists fridge (id integer primary key autoincrement, "
        + "name VARCHAR not null, duedate VARCHAR, surrogates VARCHAR, quantity integer, alarm integer );";
        
    private final Context context;    

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBFridgeAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
        	try {
        		db.execSQL(DATABASE_CREATE);	
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }    

    //---opens the database---
    public DBFridgeAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    //---insert a record into the database---
    public long insertRecord(String name, String duedate, String surrogates, long quantity, long alarm) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_DUEDATE, duedate);
        initialValues.put(KEY_SURROGATES, surrogates);
        initialValues.put(KEY_QUANTITY, quantity);
        initialValues.put(KEY_ALARM, alarm);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular record---
    public boolean deleteContact(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the records---
    public Cursor getAllRecords() 
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME,
                KEY_DUEDATE, KEY_QUANTITY, KEY_SURROGATES , KEY_ALARM}, null, null, null, null, null);
    }

    //---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_NAME, KEY_DUEDATE, KEY_QUANTITY, KEY_SURROGATES , KEY_ALARM}, 
                KEY_ROWID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a record---
    public boolean updateRecord(long rowId, String name, String duedate, String surrogates, long quantity, long alarm) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_DUEDATE, duedate);
        args.put(KEY_SURROGATES, surrogates);
        args.put(KEY_QUANTITY, quantity);
        args.put(KEY_ALARM, alarm);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
