package com.example.todolist.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.ToDo;
import com.example.todolist.presenter.DailyTasksFragmentPresenter;

import java.util.List;

public class DailyTasksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater mInflater;
    private List<ToDo> mToDoArrayList;
    private ToDo fakeToDo;
    private final DailyTasksFragmentPresenter dailyTasksFragmentPresenter;

  public DailyTasksAdapter(Context context, DailyTasksFragmentPresenter dailyTasksFragmentPresenter){
      //  this.mFakeToDoList=fakeList;
      this.dailyTasksFragmentPresenter=dailyTasksFragmentPresenter;
        this.mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        fakeToDo =mToDoArrayList.get(position);
        int done= Integer.parseInt( fakeToDo.getDone() );
        return done;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View viewTask;
      if(viewType==0) {
          viewTask = mInflater.inflate(
                  R.layout.list_item_not_done, parent, false);
              return new DailyTasksViewHolderNotDone(viewTask,this.dailyTasksFragmentPresenter);
        }else {
          viewTask = mInflater.inflate(
                  R.layout.list_item_done, parent, false);
          return new DailyTasksViewHolderDone(viewTask,this.dailyTasksFragmentPresenter);
            }

    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        fakeToDo= mToDoArrayList.get(position);
        if(holder.getItemViewType()==0) {
            DailyTasksViewHolderNotDone holderNotDone=
                            (DailyTasksViewHolderNotDone)holder;
            holderNotDone.nameView.setText(fakeToDo.getTitle());
        }else {
            DailyTasksViewHolderDone holderDone=
                    (DailyTasksViewHolderDone)holder;
            holderDone.nameView.setText(fakeToDo.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mToDoArrayList.size();
    }


    public void setList(List<ToDo> list){
        this.mToDoArrayList=list;
    }
}
