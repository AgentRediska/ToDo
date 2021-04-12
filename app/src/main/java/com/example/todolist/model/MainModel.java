package com.example.todolist.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.todolist.contract.MainContract;
import com.example.todolist.database.DatabaseHelper;

public class MainModel implements MainContract.Model {
    private static final String TAG="MainRepository";
    private DatabaseHelper dbHelper;

    final String LOG_TAG = "myLogs";

    @Override
    public void addToDoTask(Context context, String date,
                            String title, String detail) {

        dbHelper= new DatabaseHelper(context);
        SQLiteDatabase database=dbHelper.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("TITLE", title);
        contentValues.put("DONE", "0");
        contentValues.put("DETAIL", detail);
       long rowID= database.insert(DatabaseHelper.DB_TABLE,null,contentValues);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);
    }
}
