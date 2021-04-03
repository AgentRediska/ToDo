package com.example.todolist.contract;

import android.content.Context;

import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.view_fragment.FragmentOfDailyTasks;

public interface MainContract {

    interface View{
        void showText(String message);
    }

    interface Presenter{
        void setDate();
        String setInitialDateTime(Context context);
        FragmentOfDailyTasks onCreateFragmentTasks(String date);
        void onDestroy();
    }

    interface Model{
        String loadMessage();
    }
}
