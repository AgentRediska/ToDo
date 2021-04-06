package com.example.todolist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="todo_db";
    public static final String DB_TABLE="todos";
    private static final int DB_VERSION=1;

    public DatabaseHelper(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE todos (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DATE TEXT ,"+
                "TITLE TEXT ," +
                "DONE TEXT ,"+
                "DETAIL TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
