package com.awal.awalsatiaje.tugas1.biodatapegawai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
public class DbHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 6;

    static final String DATABASE_NAME = "awal.db";

    public static final String TABLE_SQLite = "sqlite";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NIK = "nik";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_JENKEL = "jenkel";
    public static final String COLUMN_TTL = "ttl";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_AGAMA = "agama";
    public static final String COLUMN_ALAMAT = "alamat";
    public static final String COLUMN_NOHP = "nohp";
    public static final String COLUMN_EMAIL = "email";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_SQLite + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY autoincrement," +
                COLUMN_NIK + " TEXT UNIQUE NOT NULL," +
                COLUMN_NAME + " TEXT NOT NULL," +
                COLUMN_JENKEL + " TEXT NOT NULL," +
                COLUMN_TTL + " TEXT NOT NULL," +
                COLUMN_STATUS + " TEXT NOT NULL," +
                COLUMN_AGAMA + " TEXT NOT NULL," +
                COLUMN_ALAMAT + " TEXT NOT NULL," +
                COLUMN_NOHP + " TEXT NOT NULL,"+
                COLUMN_EMAIL + " TEXT NOT NULL" +
                " )";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SQLite);
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_SQLite;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NIK, cursor.getString(1));
                map.put(COLUMN_NAME, cursor.getString(2));
                map.put(COLUMN_JENKEL, cursor.getString(3));
                map.put(COLUMN_TTL, cursor.getString(4));
                map.put(COLUMN_STATUS, cursor.getString(5));
                map.put(COLUMN_AGAMA, cursor.getString(6));
                map.put(COLUMN_ALAMAT, cursor.getString(7));
                map.put(COLUMN_NOHP, cursor.getString(8));
                map.put(COLUMN_EMAIL, cursor.getString(9));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        Log.e("select sqlite ", "" + wordList);

        database.close();
        return wordList;
    }

    public void insert(String nik, String name, String jenkel, String ttl, String status, String agama, String alamat, String nohp, String email) {
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO " + TABLE_SQLite + " (nik, name, jenkel, ttl, status, agama, alamat, nohp, email) " +
                "VALUES ('" + nik + "','" + name + "','" + jenkel + "','" + ttl + "','" + status + "','" + agama + "','" + alamat + "','" +  nohp + "','" + email+ "')";

        Log.e("insert sqlite ", "" + queryValues);
        database.execSQL(queryValues);
        database.close();
    }

    public void update(int id, String nik, String name, String jenkel, String ttl, String status, String agama, String alamat, String nohp, String email) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_SQLite + " SET "
                + COLUMN_NIK + "='" + nik + "',"
                + COLUMN_NAME + "='" + name + "',"
                + COLUMN_JENKEL + "='" + jenkel + "',"
                + COLUMN_TTL + "='" + ttl + "',"
                + COLUMN_STATUS + "='" + status + "',"
                + COLUMN_AGAMA + "='" + agama + "',"
                + COLUMN_ALAMAT + "='" + alamat + "',"
                + COLUMN_NOHP + "='" + nohp + "',"
                + COLUMN_EMAIL + "='" + email + "'"
                + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(int id) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "DELETE FROM " + TABLE_SQLite + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }

}
