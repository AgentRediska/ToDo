package com.example.todolist.presenter;

import com.example.todolist.contract.DailyTasksFragmentContract;
import com.example.todolist.contract.MainContract;
import com.example.todolist.model.DailyTasksFragmentModel;

public class DailyTasksFragmentPresenter implements DailyTasksFragmentContract.Presenter {

    private DailyTasksFragmentContract.Model mModel;
    private DailyTasksFragmentContract.View mView;

    public DailyTasksFragmentPresenter(DailyTasksFragmentContract.View view) {
        this.mModel = new DailyTasksFragmentModel();
        this.mView = view;
    }

    @Override
    public void onButtonCompleteAllEvent() {
        //отметить все элементы рисайкла выполненными
    }

    @Override
    public void onButtonDeleteAllEvent() {
        //удалить все элементы рисайкла
    }

    @Override
    public void onDestroy() {

    }
}
