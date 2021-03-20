package com.example.todolist.presenter;

import com.example.todolist.contract.MainContract;
import com.example.todolist.model.MainModel;

public class MainPresenter implements MainContract.Presenter {

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
    public void onDestroy() {

    }
}
