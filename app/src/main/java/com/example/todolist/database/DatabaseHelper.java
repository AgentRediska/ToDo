package com.example.todolist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="todo_db";
    private static final int DB_VERSION=1;

    DatabaseHelper(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE todos (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "text TEXT NOT NULL," +
                "created_at TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*
    public void insertWithData(String text){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("text", text);

        Date currentDate new Date();
        DateFormat dateFormat= new SimpleDateFormat("EEEE,MMM d,yyyy", Locate.getDefault() );
        String dateText=dateFormat.format(currentDate);

        drinkValues.put("created_at", dateText);
        db.insert("todos",null,drinkValues);
    }
    */
}
