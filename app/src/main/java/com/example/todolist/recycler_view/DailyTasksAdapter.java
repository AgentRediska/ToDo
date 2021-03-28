package com.example.todolist.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.FakeToDo;
import com.example.todolist.R;

import java.util.List;

public class DailyTasksAdapter extends RecyclerView.Adapter<DailyTasksViewHolder> {
    private final LayoutInflater mInflater;
    private final List<FakeToDo> mFakeToDoList;

  public DailyTasksAdapter(Context context,List<FakeToDo> fakeList){
        this.mFakeToDoList=fakeList;
        this.mInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DailyTasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.list_item,parent,false);
        return new DailyTasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyTasksViewHolder holder, int position) {
        FakeToDo fake= mFakeToDoList.get(position);
        holder.nameView.setText(fake.getName());
    }

    @Override
    public int getItemCount() {
        return mFakeToDoList.size();
    }

}
