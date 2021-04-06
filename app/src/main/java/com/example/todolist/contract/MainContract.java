package com.example.todolist.contract;

import android.content.Context;

import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.view_fragment.FragmentOfDailyTasks;

public interface MainContract {

    interface View{
        void showTextDate(String message);
        void replaceFragment();
    }

    interface Presenter{
        void setDate(String dateText);
        void selectDate();
        void generateToDo();
        void setInitialDateTime();
        FragmentOfDailyTasks onCreateFragmentTasks(String date);
        void onDestroy();
    }

    interface Model{
        String loadMessage();
        void addToDoTask(Context context, String date,
                         String title, int done, String detail);
    }
}
