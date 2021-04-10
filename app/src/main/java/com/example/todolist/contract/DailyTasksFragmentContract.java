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
         void completeToDoTask(long id);
         void deleteAllTodoForTheDay(String date);
         void completeAllTodoForTheDay(String date);
         ArrayList<ToDo>  getAllTasksFromDB();
         ArrayList<ToDo>  getAllTasksByDate( String date);
     }

     interface Presenter{
         void onButtonCompleteAllEvent();
         void onButtonDeleteAllEvent();
         void setRecyclerView(RecyclerView recyclerView);
         void onUpdateTasksOfDay();
         void onDestroy();

         ArrayList<ToDo> takeToDoFromDB();

     }
}
