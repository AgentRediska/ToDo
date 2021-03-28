package com.example.todolist.recycler_view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;

public class DailyTasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final TextView nameView;
    final Button deleteTask;

    OnBtnClickListener mOnBtnClickListener;
    DailyTasksViewHolder(View view,final OnBtnClickListener onClickLis){
        super(view);
        this.mOnBtnClickListener=onClickLis;
        nameView=(TextView)view.findViewById(R.id.nameToDo);
        deleteTask=(Button) view.findViewById(R.id.btnDeleteToDo);

        deleteTask.setOnClickListener(v->{
            if(mOnBtnClickListener!=null){
                int position= getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION){
                    mOnBtnClickListener.onDeleteTask(position);
                }
            }
                });
    }

    @Override
    public void onClick(View v) {

    }

    public interface OnBtnClickListener{
        void onDeleteTask(int position);
    }
}