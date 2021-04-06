package com.example.todolist.contract;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface DailyTasksFragmentContract {

     interface View{
     }

     interface Model{
         String loadMessage();
         void deleteToDoTask();
     }

     interface Presenter{
         void onButtonCompleteAllEvent();
         void onButtonDeleteAllEvent();
         void setRecyclerView(Context context, RecyclerView recyclerView);
         void onDestroy();
     }
}
