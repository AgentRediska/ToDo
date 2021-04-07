package com.example.todolist.contract;

import android.content.ContentValues;
import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.ToDo;

import java.util.ArrayList;

public interface DailyTasksFragmentContract {

     interface View{
     }

     interface Model{
         void deleteToDoTask(long id);
         ArrayList<ToDo>  getAllTasksFromDB();
     }

     interface Presenter{
         void onButtonCompleteAllEvent();
         void onButtonDeleteAllEvent();
         void setRecyclerView(RecyclerView recyclerView);
         void onDestroy();

         ArrayList<ToDo> takeToDoFromDB();

     }
}
