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
    public void deleteToDoTask() {
        //
    }

    @Override
    public void getTasksFromDB() {
        SQLiteDatabase database=mDatabaseHelper.getReadableDatabase();
        Cursor cursor=database.query(DatabaseHelper.DB_TABLE,null,null,
                null,null,null,null);

        if (cursor.moveToFirst()){
            getToDoArrayList(cursor);
        }else{cursor.close();}
    }



    private ArrayList<ToDo> getToDoArrayList(Cursor local_cursor) {
        ArrayList<ToDo> mToDoArrayList = new ArrayList<>();

            int idColIndex = local_cursor.getColumnIndex("_id");
            int dateColIndex = local_cursor.getColumnIndex("DATE");
            int titleColIndex = local_cursor.getColumnIndex("TITLE");
            int doneColIndex = local_cursor.getColumnIndex("DONE");
            int detailColIndex = local_cursor.getColumnIndex("DETAIL");

            do {
                ToDo toDo = new ToDo();
                toDo.setId(local_cursor.getInt(idColIndex));
                toDo.setDate(local_cursor.getString(dateColIndex));
                toDo.setTitle(local_cursor.getString(titleColIndex));
                toDo.setDone(local_cursor.getString(doneColIndex));
                toDo.setDetail(local_cursor.getString(detailColIndex));
                mToDoArrayList.add(toDo);
            } while (local_cursor.moveToNext());

        return mToDoArrayList;
    }

}
