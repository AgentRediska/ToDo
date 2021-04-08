package com.example.todolist.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.todolist.ToDo;
import com.example.todolist.contract.DailyTasksFragmentContract;
import com.example.todolist.database.DatabaseHelper;

import java.util.ArrayList;

public class DailyTasksFragmentModel implements DailyTasksFragmentContract.Model {

    final String LOG_TAG = "myLogs";

   private DatabaseHelper mDatabaseHelper;
   private Context mContext;

    public DailyTasksFragmentModel(Context context) {
        this.mContext = context;
        mDatabaseHelper= new DatabaseHelper(mContext);
    }

    @Override
    public void completeToDoTask(long id) {
        SQLiteDatabase database=mDatabaseHelper.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("DONE","1");
        database.update(DatabaseHelper.DB_TABLE,cv,"_id = "+id,null);
        mDatabaseHelper.close();
    }

    @Override
    public void deleteToDoTask(long id) {
        SQLiteDatabase database=mDatabaseHelper.getWritableDatabase();
        database.delete(DatabaseHelper.DB_TABLE,"_id = "+id,null);
        mDatabaseHelper.close();
    }

    @Override
    public ArrayList<ToDo>  getAllTasksFromDB() {
        SQLiteDatabase database=mDatabaseHelper.getReadableDatabase();
        ArrayList<ToDo> mToDoArrayList = new ArrayList<>();
        Cursor cursor=database.query(DatabaseHelper.DB_TABLE,null,null,
                null,null,null,null);

        if (cursor.moveToFirst()){
            mDatabaseHelper.close();
            return getToDoArrayList(cursor);
        }else
            mDatabaseHelper.close();
            return mToDoArrayList;
    }

    @Override
    public ArrayList<ToDo> getAllTasksByDate(String date) {
        Log.d(LOG_TAG, "DATE = " + date);
        SQLiteDatabase database=mDatabaseHelper.getReadableDatabase();
        ArrayList<ToDo> mToDoArrayList = new ArrayList<>();
        String selection="DATE = ?";
        String[] selectionArgs= new String[]{ date };
        Cursor cursor=database.query(DatabaseHelper.DB_TABLE,null,selection,
                selectionArgs,null,null,null);

        if (cursor.moveToFirst()){
            mDatabaseHelper.close();
            return getToDoArrayList(cursor);
        }else
            mDatabaseHelper.close();
        return mToDoArrayList;
    }

    @Override
    public void deleteAllTodoForTheDay(String date) {
        SQLiteDatabase database=mDatabaseHelper.getWritableDatabase();
        database.delete(DatabaseHelper.DB_TABLE,"DATE = \""+date +"\"",null);
        mDatabaseHelper.close();
    }


    private ArrayList<ToDo> getToDoArrayList(Cursor localCursor) {

        ArrayList<ToDo> list = new ArrayList<>();
            int idColIndex = localCursor.getColumnIndex("_id");
            int dateColIndex = localCursor.getColumnIndex("DATE");
            int titleColIndex = localCursor.getColumnIndex("TITLE");
            int doneColIndex = localCursor.getColumnIndex("DONE");
            int detailColIndex = localCursor.getColumnIndex("DETAIL");

            do {
                ToDo toDo = new ToDo();
                toDo.setId(localCursor.getInt(idColIndex));
                toDo.setDate(localCursor.getString(dateColIndex));
                toDo.setTitle(localCursor.getString(titleColIndex));
                toDo.setDone(localCursor.getString(doneColIndex));
                toDo.setDetail(localCursor.getString(detailColIndex));
                list.add(toDo);
            } while (localCursor.moveToNext());

        return list;
    }

}
