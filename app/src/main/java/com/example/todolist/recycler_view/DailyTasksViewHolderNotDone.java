package com.example.todolist.recycler_view;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.presenter.DailyTasksFragmentPresenter;

public class DailyTasksViewHolderNotDone extends RecyclerView.ViewHolder
                            implements View.OnClickListener{
    final TextView nameTextView;
    final Button deleteTaskBtn;
    final Button completeTaskBtn;
    final TextView detailTextView;
    final LinearLayout expandableLayout;
    @Override
    public void onClick(View v) {

    }



    DailyTasksViewHolderNotDone(View view, DailyTasksFragmentPresenter dailyTasksFragmentPresenter){
        super(view);

        expandableLayout=(LinearLayout)itemView.findViewById(R.id.expandableLayout);


        nameTextView=(TextView)view.findViewById(R.id.nameToDo);
        nameTextView.setOnClickListener(v -> {
            //set
            if(expandableLayout.getVisibility()== View.GONE){
                expandableLayout.setVisibility(View.VISIBLE);
            }else expandableLayout.setVisibility(View.GONE);

        });

        detailTextView=(TextView)itemView.findViewById(R.id.detailTextView);

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
