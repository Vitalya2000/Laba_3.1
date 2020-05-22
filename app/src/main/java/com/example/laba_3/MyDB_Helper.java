package com.example.laba_3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB_Helper  extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyDb";
    public static final String TABLE_STUDENTS = "Students";

    public static final String KEY_ID = "ID";
    public static final String KEY_FIO = "FIO";
    public static final String KEY_DATE = "Date";

    public MyDB_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_STUDENTS + "(" + KEY_ID
                + " integer primary key," + KEY_FIO + " text," + KEY_DATE + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_STUDENTS);
        onCreate(db);
    }
}
