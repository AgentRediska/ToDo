package com.example.todolist.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.todolist.ToDo;
import com.example.todolist.contract.DailyTasksFragmentContract;
import com.example.todolist.database.DatabaseHelper;

import java.util.ArrayList;

public class DailyTasksFragmentModel implements DailyTasksFragmentContract.Model {
   private DatabaseHelper mDatabaseHelper;
   private Context mContext;

    public DailyTasksFragmentModel(Context context) {
        this.mContext = context;
        mDatabaseHelper= new DatabaseHelper(mContext);
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
