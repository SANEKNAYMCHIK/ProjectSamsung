package com.example.projectsamsung.db;

public class MyConstants {
    public static final String TABLE_NAME = "my_table";
    public static final String ID = "id";
    public static final String VALUE = "value";
    public static final String NAME = "name";
    public static final String DB_NAME = "project_db.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            " (" + ID + " INTEGER PRIMARY KEY," + VALUE + " INTEGER," + NAME + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
