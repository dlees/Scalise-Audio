package com.example.simplemusicplayer;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import database.Database;

public class AndroidDatabase implements Database {
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_FILENAME = "filename";
	public static final String COLUMN_STARTSEC = "start_sec";
	public static final String COLUMN_ENDSEC = "end_sec";
	public static final String COLUMN_TIMESTAMP = "timestamp";

	private static final String DATABASE_NAME = "data";
	private static final String TABLE_NAME = "sec_count_prototype";
	private static final int DATABASE_VERSION = 1;
	
	public static final String[] allColumns = new String[] {COLUMN_ID, COLUMN_FILENAME, COLUMN_STARTSEC, COLUMN_ENDSEC, COLUMN_TIMESTAMP};
	private static DatabaseHelper dbHelper; 
	private SQLiteDatabase db;
	private Context mContext;
	
	private static final String CREATE_TABLE =
		"CREATE TABLE IF NOT EXISTS " 
		+ TABLE_NAME + " ( "
		+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
		+ COLUMN_FILENAME + " TEXT NOT NULL, "
		+ COLUMN_STARTSEC + " REAL, "
		+ COLUMN_ENDSEC + " REAL, "
		+ COLUMN_TIMESTAMP + " TEXT "
		+ ");";
	private static final String DELETE_TABLE =
		"DROP TABLE IF EXISTS " + TABLE_NAME + " ";
	
	//Helps with database creation
	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {		
			db.execSQL(CREATE_TABLE);
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("AndroidDatabase", "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL(DELETE_TABLE);
            onCreate(db);
		}
	}
	public AndroidDatabase(Context context) {
		this.mContext = context;
		
	}
	
	
	
	//Calls up an instance of DBHelper
	public AndroidDatabase open() throws SQLException {
		dbHelper = new DatabaseHelper(mContext);
		//Handles creating/opening database
		db = dbHelper.getWritableDatabase();
		return this;
	}
	public void close() {
		dbHelper.close();
	}

	public void deleteTable() {
		db.delete(TABLE_NAME, null, null);
	}
    
    
	
	@Override
	public void insert_sec_count(String filename, long start_sec, long end_sec) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		Timestamp timestampVal = new Timestamp(now.getTime());
		String timestamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.SSS").format(timestampVal);
	
		ContentValues values = new ContentValues();

		values.put(COLUMN_FILENAME, filename);
		values.put(COLUMN_STARTSEC, start_sec);
		values.put(COLUMN_ENDSEC, end_sec);
		values.put(COLUMN_TIMESTAMP, timestamp);

		Log.d("AndroidDatabase", "Inserted into database: " + filename + " " + start_sec + " " + end_sec + " " + timestamp);
		db.insert(TABLE_NAME, null, values);
	}
	
    public Cursor getAll() {

        return db.query(TABLE_NAME, allColumns, null, null, null, null, null);
    }
}
