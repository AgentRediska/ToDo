package com.example.todolist.presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.ToDo;
import com.example.todolist.contract.DailyTasksFragmentContract;
import com.example.todolist.model.DailyTasksFragmentModel;
import com.example.todolist.recycler_view.DailyTasksAdapter;
import com.example.todolist.recycler_view.DailyTasksViewHolder;

import java.util.ArrayList;

public class DailyTasksFragmentPresenter implements DailyTasksFragmentContract.Presenter, DailyTasksViewHolder.OnBtnClickListener {

    private DailyTasksFragmentContract.Model mModel;
    private DailyTasksFragmentContract.View mView;
    private Context mContext;

    private DailyTasksAdapter dailyTasksAdapter;
    //!
    ArrayList<ToDo> mToDoArrayList;

    public DailyTasksFragmentPresenter(DailyTasksFragmentContract.View view,Context context) {
        this.mContext=context;
        this.mModel = new DailyTasksFragmentModel(mContext);
        this.mView = view;

         mToDoArrayList= takeToDoFromDB();


    }

    @Override
    public void onButtonCompleteAllEvent() {
        //отметить все элементы рисайкла выполненными
    }

    @Override
    public void onButtonDeleteAllEvent() {
        //удалить все элементы рисайкла
        //mFakeToDoArrayList.clear();
        //dailyTasksAdapter.notifyDataSetChanged();
    }

    @Override
    public void setRecyclerView(RecyclerView recyclerView) {
        dailyTasksAdapter= new DailyTasksAdapter(mContext,this::onDeleteTaskBtnClick);
        dailyTasksAdapter.setList(mToDoArrayList);
        recyclerView.setAdapter(dailyTasksAdapter);
    }

    @Override
    public void onDestroy() {

    }


    @Override
    public void onDeleteTaskBtnClick(int position) {
       // mFakeToDoArrayList.remove(position);
       // dailyTasksAdapter.notifyItemRemoved(position);
    }

    @Override
    public ArrayList<ToDo> takeToDoFromDB() {
       return mModel.getTasksFromDB();
    }
}
