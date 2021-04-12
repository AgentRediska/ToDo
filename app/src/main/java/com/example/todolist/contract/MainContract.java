package com.example.todolist.contract;

import android.content.Context;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.ToDo;
import com.example.todolist.view_fragment.CreateToDoFragment;
import com.example.todolist.view_fragment.FragmentOfDailyTasks;

public interface MainContract {

    interface View{
        void showTextDate(String message);
        void replaceFragment();
    }

    interface Presenter{
        void setDate(String dateText);
        void selectDate();
        void setTask(ToDo task);
        void setInitialDateTime();
        void setInitialNumericDateTime();
        FragmentOfDailyTasks onCreateFragmentTasks();
        CreateToDoFragment onCreateCreateToDoFragment();
        void onDestroy();
    }

    interface Model{
        void addToDoTask(Context context, String date,
                         String title, String detail);
    }
}
