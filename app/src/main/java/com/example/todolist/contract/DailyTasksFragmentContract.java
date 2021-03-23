package com.example.todolist.contract;

public interface DailyTasksFragmentContract {

     interface View{
     }

     interface Model{
         String loadMessage();
     }

     interface Presenter{
         void onButtonCompleteAllEvent();
         void onButtonDeleteAllEvent();
         void onDestroy();
     }
}
