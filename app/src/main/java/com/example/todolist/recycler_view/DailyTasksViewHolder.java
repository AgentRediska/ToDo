package com.example.todolist.recycler_view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;

public class DailyTasksViewHolder extends RecyclerView.ViewHolder {
    final TextView nameView;
    final Button deleteTask;

    DailyTasksViewHolder(View view){
        super(view);

        nameView=(TextView)view.findViewById(R.id.nameToDo);
        deleteTask=(Button) view.findViewById(R.id.btnDeleteToDo);

    }

}