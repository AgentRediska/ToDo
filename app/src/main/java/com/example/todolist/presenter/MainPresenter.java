package com.example.todolist.presenter;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.contract.MainContract;
import com.example.todolist.model.MainModel;
import com.example.todolist.view_fragment.FragmentOfDailyTasks;
import com.example.todolist.view_fragment.MainFragment;

public class MainPresenter implements MainContract.Presenter {
    FragmentTransaction ftAddFrag;
    private MainContract.View mView;
    private MainContract.Model mModel;

    private String message;

    public MainPresenter(MainContract.View mView){
        this.mView=mView;
        this.mModel= new MainModel();

    }

    @Override
    public void onButtonAddEvent() {
        message=mModel.loadMessage();
        mView.showText(message);

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
