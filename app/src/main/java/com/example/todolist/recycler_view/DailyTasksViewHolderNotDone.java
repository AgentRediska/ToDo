package com.example.todolist.recycler_view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.presenter.DailyTasksFragmentPresenter;

public class DailyTasksViewHolderNotDone extends RecyclerView.ViewHolder
                            implements View.OnClickListener{
    final TextView nameView;
    final Button deleteTaskBtn;
    final Button completeTaskBtn;

    @Override
    public void onClick(View v) {

    }



    DailyTasksViewHolderNotDone(View view, DailyTasksFragmentPresenter dailyTasksFragmentPresenter){
        super(view);

        nameView=(TextView)view.findViewById(R.id.nameToDo);
        deleteTaskBtn=(Button) view.findViewById(R.id.btnDeleteToDo);
        deleteTaskBtn.setOnClickListener(v->{
            int position=getAdapterPosition();
            dailyTasksFragmentPresenter.onDeleteTaskBtnClick(position);
        });

        completeTaskBtn=(Button)view.findViewById(R.id.btnMarkCompleted);
        completeTaskBtn.setOnClickListener(v -> {
            int position=getAdapterPosition();
            dailyTasksFragmentPresenter.onCompeteTaskBtnClick(position);
        });


    }

}
