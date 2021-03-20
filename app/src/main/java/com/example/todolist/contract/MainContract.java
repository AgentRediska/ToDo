package com.example.todolist.contract;

import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.view_fragment.FragmentOfDailyTasks;

public interface MainContract {

    interface View{
        void showText(String message);
    }

    interface Presenter{
        void onButtonAddEvent();
        FragmentOfDailyTasks onCreateFragmentTasks(String date);
        void onDestroy();
    }

    interface Model{
        String loadMessage();
    }
}
