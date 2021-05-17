package com.example.todolist.recycler_view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.presenter.DailyTasksFragmentPresenter;

public class DailyTasksViewHolderDone extends RecyclerView.ViewHolder
        implements View.OnClickListener{

    final TextView nameTextView;
    final Button deleteTaskBtn;
    final TextView detailTextView;
    final LinearLayout expandableLayout;

    @Override
    public void onClick(View v) {

    }

    public DailyTasksViewHolderDone(@NonNull View itemView,  DailyTasksFragmentPresenter dailyTasksFragmentPresenter) {
        super(itemView);

        expandableLayout=(LinearLayout)itemView.findViewById(R.id.expandableLayout);
        nameTextView=(TextView)itemView.findViewById(R.id.nameToDo);
        nameTextView.setOnClickListener(v -> {
                //set
            if(expandableLayout.getVisibility()== View.GONE){
                expandableLayout.setVisibility(View.VISIBLE);
            }else expandableLayout.setVisibility(View.GONE);

        });

        detailTextView=(TextView)itemView.findViewById(R.id.detailTextView);

        deleteTaskBtn=(Button) itemView.findViewById(R.id.btnDeleteToDo);
        deleteTaskBtn.setOnClickListener(v->{
            int position=getAdapterPosition();
            dailyTasksFragmentPresenter.onDeleteTaskBtnClick(position);
        });

    }

}
