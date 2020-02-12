package com.example.notelocationtake;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Notes.db";
    public static final String TABLE_NAME = "NotesTable";

    public static final String ID = "ID";
    public static final String TITLE = "Title";
    public static final String CONTENT = "Content";
    public static final String DATE = "Date";
    public static final String TIME = "Time";
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
        onCreate(sqLiteDatabase);
    }

    public long addNote(Note note){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE,note.getTitle());
        contentValues.put(CONTENT,note.getContent());
        contentValues.put(DATE,note.getDate());
        contentValues.put(TIME,note.getTime());

        long ID = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        Log.d("Inserted","ID = "+ID);
        return ID;

    }

    public Note getNote(long id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{ID,TITLE,CONTENT,DATE,TIME,ADDRESS},ID+"=?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new Note(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5));
    }

    public List<Note> getNotes(){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<Note> allNotes = new ArrayList<>();

        String query = "SELECT * FROM " +TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if (cursor!=null){
            while (cursor.moveToNext()){
                Note note = new Note();
                note.setID(cursor.getLong(0));
                note.setTitle(cursor.getString(1));
                note.setContent(cursor.getString(2));
                note.setDate(cursor.getString(3));
                note.setTime(cursor.getString(4));
                note.setAddress(cursor.getString(5));

                allNotes.add(note);
            }

        }

        return allNotes;

    }

    void deleteNote(long id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,ID+"=?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

}
