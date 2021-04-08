package com.example.todolist.recycler_view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.presenter.DailyTasksFragmentPresenter;

public class DailyTasksViewHolderDone extends RecyclerView.ViewHolder
        implements View.OnClickListener{

    final TextView nameView;
    final Button deleteTask;

    @Override
    public void onClick(View v) {

    }

    public DailyTasksViewHolderDone(@NonNull View itemView,  DailyTasksFragmentPresenter dailyTasksFragmentPresenter) {
        super(itemView);

        nameView=(TextView)itemView.findViewById(R.id.nameToDo);
        deleteTask=(Button) itemView.findViewById(R.id.btnDeleteToDo);
        deleteTask.setOnClickListener(v->{
            int position=getAdapterPosition();
            dailyTasksFragmentPresenter.onDeleteTaskBtnClick(position);
        });

    }

}
