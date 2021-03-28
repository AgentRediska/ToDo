package com.example.todolist.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.FakeToDo;
import com.example.todolist.contract.DailyTasksFragmentContract;
import com.example.todolist.contract.MainContract;
import com.example.todolist.model.DailyTasksFragmentModel;
import com.example.todolist.recycler_view.DailyTasksAdapter;
import com.example.todolist.recycler_view.DailyTasksViewHolder;

import java.util.ArrayList;

public class DailyTasksFragmentPresenter implements DailyTasksFragmentContract.Presenter,
        DailyTasksViewHolder.OnBtnClickListener {

    private DailyTasksFragmentContract.Model mModel;
    private DailyTasksFragmentContract.View mView;

    private DailyTasksAdapter dailyTasksAdapter;
    //!
    ArrayList<FakeToDo> mFakeToDoArrayList= new ArrayList<>();

    public DailyTasksFragmentPresenter(DailyTasksFragmentContract.View view) {
        this.mModel = new DailyTasksFragmentModel();
        this.mView = view;

        //!
        mFakeToDoArrayList.add(new FakeToDo("Go"));
        mFakeToDoArrayList.add(new FakeToDo("Find"));
        mFakeToDoArrayList.add(new FakeToDo("dwdwddddddddddddddddddddd"));
        mFakeToDoArrayList.add(new FakeToDo("q"));
        mFakeToDoArrayList.add(new FakeToDo("Gwdwdqrwqrwro"));
        mFakeToDoArrayList.add(new FakeToDo("3dqwd"));
        mFakeToDoArrayList.add(new FakeToDo("Go"));
        mFakeToDoArrayList.add(new FakeToDo("Fwdfwqfind"));
        mFakeToDoArrayList.add(new FakeToDo("Ggrgo"));
        mFakeToDoArrayList.add(new FakeToDo("Find"));
        mFakeToDoArrayList.add(new FakeToDo("Gofewfewfewfvgse"));
        mFakeToDoArrayList.add(new FakeToDo("Fqwewwwfqind"));

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
    public void setRecyclerView(Context context, RecyclerView recyclerView) {
        dailyTasksAdapter= new DailyTasksAdapter(context,mFakeToDoArrayList);
        recyclerView.setAdapter(dailyTasksAdapter);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDeleteTask(int position) {

    }
}
