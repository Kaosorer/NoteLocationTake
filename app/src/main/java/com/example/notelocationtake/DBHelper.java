package com.example.notelocationtake;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Notes.db";
    public static final String TABLE_NAME = "NotesTable";
    public static final String ID = "ID";
    public static final String TITLE = "Title";
    public static final String DATE = "Date";
    public static final String TIME = "Time";
    public static final String CONTENT = "Content";
    public static final String ADDRESS = "Address";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE "+TABLE_NAME+
                "("+
                        ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        TITLE+" TEXT,"+
                        CONTENT+" TEXT,"+
                        DATE+" TEXT,"+
                        TIME+" TEXT,"+
                        ADDRESS+" TEXT"+
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
}
