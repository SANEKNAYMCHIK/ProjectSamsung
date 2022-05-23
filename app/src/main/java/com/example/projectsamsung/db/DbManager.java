package com.example.projectsamsung.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

public class DbManager {
    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public DbManager(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }

    public void openDb() {
        db = dbHelper.getWritableDatabase();
    }

    public void insert(Integer value, String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyConstants.VALUE, value);
        contentValues.put(MyConstants.NAME, name);
        db.insert(MyConstants.TABLE_NAME, null, contentValues);
    }

    public Map<String, Integer> get() {
        Map<String, Integer> tempmap = new HashMap<>();
        Cursor cursor = db.query(MyConstants.TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(MyConstants.NAME));
            @SuppressLint("Range") Integer value = cursor.getInt(cursor.getColumnIndex(MyConstants.VALUE));
            tempmap.put(name, value);

        }
        cursor.close();
        return tempmap;
    }

    public void update(String name, int sum_or_diff) {
        if (sum_or_diff != 0) {
            Cursor cursor = db.query(MyConstants.TABLE_NAME, null, null, null, null, null, null);
            ContentValues contentValues = new ContentValues();

            while (cursor.moveToNext()) {
                @SuppressLint("Range") String name_val = cursor.getString(cursor.getColumnIndex(MyConstants.NAME));
                contentValues.put(MyConstants.NAME, name_val);
                @SuppressLint("Range") Integer value = cursor.getInt(cursor.getColumnIndex(MyConstants.VALUE)) + sum_or_diff;
                contentValues.put(MyConstants.VALUE, value);
                if (name_val.equals(name))break;
            }
            db = dbHelper.getWritableDatabase();
            db.update(MyConstants.TABLE_NAME, contentValues, "name = ?", new String[]{name});
            cursor.close();
        } else {
            Cursor cursor = db.query(MyConstants.TABLE_NAME, null, null, null, null, null, null);
            ContentValues contentValues = new ContentValues();

            while (cursor.moveToNext()) {
                @SuppressLint("Range") String name_val = cursor.getString(cursor.getColumnIndex(MyConstants.NAME));
                contentValues.put(MyConstants.NAME, name_val);
                @SuppressLint("Range") Integer value = 1;
                contentValues.put(MyConstants.VALUE, value);
                if (name_val.equals(name))break;
            }
            db = dbHelper.getWritableDatabase();
            db.update(MyConstants.TABLE_NAME, contentValues, "name = ?", new String[]{name});
            cursor.close();
        }
    }

    public void close() {
        dbHelper.close();
    }
}
