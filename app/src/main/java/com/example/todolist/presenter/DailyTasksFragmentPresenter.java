package com.example.todolist.presenter;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.ToDo;
import com.example.todolist.contract.DailyTasksFragmentContract;
import com.example.todolist.model.DailyTasksFragmentModel;
import com.example.todolist.recycler_view.DailyTasksAdapter;

import java.util.ArrayList;

public class DailyTasksFragmentPresenter implements DailyTasksFragmentContract.Presenter {

    public final String TAG = "myLogs";

    private DailyTasksFragmentContract.Model mModel;
    private DailyTasksFragmentContract.View mView;
    private final Context mContext;
    private final String date;
    private  static ToDo oneTask;

    private DailyTasksAdapter dailyTasksAdapter;
    //!
    ArrayList<ToDo> mToDoArrayList;

    public DailyTasksFragmentPresenter(DailyTasksFragmentContract.View view,Context context, String date) {
        this.date=date;
        this.mContext=context;
        this.mModel = new DailyTasksFragmentModel(mContext);
        this.mView = view;

         mToDoArrayList= takeToDoFromDB();


    }

    @Override
    public void onButtonCompleteAllEvent() {
        //отметить все элементы рисайкла выполненными
       mModel.completeAllTodoForTheDay(date);
       mToDoArrayList.clear();
       mToDoArrayList.addAll(takeToDoFromDB());
       dailyTasksAdapter.notifyDataSetChanged();
    }

    @Override
    public void onButtonDeleteAllEvent() {
        mModel.deleteAllTodoForTheDay(date);
        mToDoArrayList.clear();
        dailyTasksAdapter.notifyDataSetChanged();
    }

    @Override
    public void setRecyclerView(RecyclerView recyclerView) {
        dailyTasksAdapter= new DailyTasksAdapter(mContext,this);
        dailyTasksAdapter.setList(mToDoArrayList);
        recyclerView.setAdapter(dailyTasksAdapter);
    }

    @Override
    public void onDestroy() {

    }

    public void onDeleteTaskBtnClick(int position) {
        oneTask= mToDoArrayList.get(position);
       mModel.deleteToDoTask(oneTask.getId());
       long id= oneTask.getId();

        mToDoArrayList.remove(position);
        dailyTasksAdapter.notifyItemRemoved(position);
    }

    public void onCompeteTaskBtnClick(int position) {
        oneTask= mToDoArrayList.get(position);
        mModel.completeToDoTask(oneTask.getId());
        long id= oneTask.getId();

        oneTask.setDone("1");
        mToDoArrayList.set(position,oneTask);

        dailyTasksAdapter.notifyItemChanged(position);
    }

    public void onUpdateTasksOfDay(){
        mToDoArrayList=takeToDoFromDB();
        dailyTasksAdapter.notifyDataSetChanged();
    }

    @Override
    public ArrayList<ToDo> takeToDoFromDB() {
       return mModel.getAllTasksByDate(date);
    }
}
