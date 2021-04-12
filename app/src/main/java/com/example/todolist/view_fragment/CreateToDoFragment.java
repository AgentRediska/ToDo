package com.example.todolist.view_fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.todolist.R;
import com.example.todolist.ToDo;


public class CreateToDoFragment extends DialogFragment {

    private TextView dateTextView;
    private Button calendarDialogBtn;
    private Button closeBtn;
    private Button applyBtn;

    private Bundle mBundle;
    private static final String ARG_TODAY_DATE="date";
    private String dateText;
    private String dateNumericText;
    private static final String ARG_TODAY_NUMERIC_DATE="numeric_date";



    public static CreateToDoFragment newInstance(String date,String numericDate) {
          Bundle args = new Bundle();
          args.putString(ARG_TODAY_DATE, date);
          args.putString(ARG_TODAY_NUMERIC_DATE,numericDate);
          CreateToDoFragment fragment = new CreateToDoFragment();
          fragment.setArguments(args);
          return fragment;
       }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle=this.getArguments();
        dateText=mBundle.getString(ARG_TODAY_DATE);
        dateNumericText=mBundle.getString(ARG_TODAY_NUMERIC_DATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_create_to_do,null);

        dateTextView= view.findViewById(R.id.dateTextView);
        dateTextView.setText(dateText);

        calendarDialogBtn=view.findViewById(R.id.calendarDialogBtn);
        calendarDialogBtn.setOnClickListener(v-> {
            //dwdw
        });

        applyBtn=view.findViewById(R.id.applyBtn);
        applyBtn.setOnClickListener(v->{
            Intent intent=createIntentBox();
            getTargetFragment().onActivityResult(
                    getTargetRequestCode(), Activity.RESULT_OK,intent);
            getFragmentManager().popBackStack();
        });

        closeBtn=view.findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(v->{
            getFragmentManager().popBackStack();
        });
        return view;
    }

    private Intent createIntentBox(){
        Intent intent=new Intent();
        ToDo task=createTask();
        intent.putExtra("NEW_TASK",task);
        return intent;
    }

    private ToDo createTask(){
        ToDo task= new ToDo();
        task.setTitle("Пример");
        task.setDone("0");
        task.setDetail("ExampleExample");
        task.setDate("12.04.2021");
        return task;
    }
}