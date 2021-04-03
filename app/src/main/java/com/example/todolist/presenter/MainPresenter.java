package com.example.todolist.presenter;

import android.content.Context;
import android.text.format.DateUtils;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.contract.MainContract;
import com.example.todolist.model.MainModel;
import com.example.todolist.view_fragment.FragmentOfDailyTasks;
import com.example.todolist.view_fragment.MainFragment;

import java.util.Calendar;

public class MainPresenter implements MainContract.Presenter {
    FragmentTransaction ftAddFrag;
    private MainContract.View mView;
    private MainContract.Model mModel;

    private Calendar dateAndTime=Calendar.getInstance();
    private String message;

    public MainPresenter(MainContract.View mView){
        this.mView=mView;
        this.mModel= new MainModel();

    }

    @Override
    public void setDate() {

        message=mModel.loadMessage();
        mView.showText(message);

    }

    @Override
    public String setInitialDateTime(Context context) {
        String dateText= DateUtils.formatDateTime(context,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE| DateUtils.FORMAT_SHOW_YEAR);
        return dateText;
    }

    @Override
    public FragmentOfDailyTasks onCreateFragmentTasks(String date) {
        FragmentOfDailyTasks fragmentOfDailyTasks= FragmentOfDailyTasks.newFragmentOfDailyTasks(date);
        return fragmentOfDailyTasks;
    }

    @Override
    public void onDestroy() {

    }
}
