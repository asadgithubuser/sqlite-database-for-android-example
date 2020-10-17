package com.example.databaseexample2.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	public static final String TAG = "DBHelper";

	// columns of the companies table
	public static final String TABLE_COMPANIES = "companies";
	public static final String COLUMN_COMPANY_ID = "_id";
	public static final String COLUMN_COMPANY_NAME = "company_name";
	public static final String COLUMN_COMPANY_ADDRESS = "address";
	public static final String COLUMN_COMPANY_WEBSITE = "website";
	public static final String COLUMN_COMPANY_PHONE_NUMBER = "phone_number";

	// columns of the employees table
	public static final String TABLE_EMPLOYEES = "employees";
	public static final String COLUMN_EMPLOYE_ID = COLUMN_COMPANY_ID;
	public static final String COLUMN_EMPLOYE_FIRST_NAME = "first_name";
	public static final String COLUMN_EMPLOYE_LAST_NAME = "last_name";
	public static final String COLUMN_EMPLOYE_ADDRESS = COLUMN_COMPANY_ADDRESS;
	public static final String COLUMN_EMPLOYE_EMAIL = "email";
	public static final String COLUMN_EMPLOYE_PHONE_NUMBER = COLUMN_COMPANY_PHONE_NUMBER;
	public static final String COLUMN_EMPLOYE_SALARY = "salary";
	public static final String COLUMN_EMPLOYE_COMPANY_ID = "company_id";

	private static final String DATABASE_NAME = "companies.db";
	private static final int DATABASE_VERSION = 1;

	// SQL statement of the employees table creation
	private static final String SQL_CREATE_TABLE_EMPLOYEES = "CREATE TABLE " + TABLE_EMPLOYEES + "(" 
			+ COLUMN_EMPLOYE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COLUMN_EMPLOYE_FIRST_NAME + " TEXT NOT NULL, "
			+ COLUMN_EMPLOYE_LAST_NAME + " TEXT NOT NULL, "
			+ COLUMN_EMPLOYE_ADDRESS + " TEXT NOT NULL, "
			+ COLUMN_EMPLOYE_EMAIL + " TEXT NOT NULL, "
			+ COLUMN_EMPLOYE_PHONE_NUMBER + " TEXT NOT NULL, "
			+ COLUMN_EMPLOYE_SALARY + " REAL NOT NULL, "
			+ COLUMN_EMPLOYE_COMPANY_ID + " INTEGER NOT NULL "
			+");";

	// SQL statement of the companies table creation
	private static final String SQL_CREATE_TABLE_COMPANIES = "CREATE TABLE " + TABLE_COMPANIES + "(" 
			+ COLUMN_COMPANY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ COLUMN_COMPANY_NAME + " TEXT NOT NULL, "
			+ COLUMN_COMPANY_ADDRESS + " TEXT NOT NULL, "
			+ COLUMN_COMPANY_WEBSITE + " TEXT NOT NULL, "
			+ COLUMN_COMPANY_PHONE_NUMBER + " TEXT NOT NULL "
			+");";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(SQL_CREATE_TABLE_COMPANIES);
		database.execSQL(SQL_CREATE_TABLE_EMPLOYEES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TAG,
				"Upgrading the database from version " + oldVersion + " to "+ newVersion);
		// clear all data
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANIES);
		
		// recreate the tables
		onCreate(db);
	}

	public DBHelper(Context context, String name, CursorFactory factory,int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
}
