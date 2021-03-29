package com.example.todolist.recycler_view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;

public class DailyTasksViewHolder extends RecyclerView.ViewHolder
                            implements View.OnClickListener{
    final TextView nameView;
    final Button deleteTask;
    OnBtnClickListener mOnBtnClickListener;

    @Override
    public void onClick(View v) {

    }

    public interface OnBtnClickListener{
        void onDeleteTaskBtnClick(int position);
    }

    DailyTasksViewHolder(View view, final OnBtnClickListener mOnBtnClickLis){
        super(view);
        this.mOnBtnClickListener=mOnBtnClickLis;
        nameView=(TextView)view.findViewById(R.id.nameToDo);
        deleteTask=(Button) view.findViewById(R.id.btnDeleteToDo);
        deleteTask.setOnClickListener(v->{
            int position=getAdapterPosition();
            mOnBtnClickListener.onDeleteTaskBtnClick(position);
        });
    }

}
