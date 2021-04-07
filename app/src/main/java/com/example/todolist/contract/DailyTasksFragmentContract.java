package com.example.todolist.contract;

import android.content.ContentValues;
import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface DailyTasksFragmentContract {

     interface View{
     }

     interface Model{
         void deleteToDoTask();
         void getTasksFromDB();
     }

     interface Presenter{
         void onButtonCompleteAllEvent();
         void onButtonDeleteAllEvent();
         void takeToDoFromDB();
         void setRecyclerView(RecyclerView recyclerView);
         void onDestroy();
     }
}
