package com.example.todolist.view_fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.todolist.R;
import com.example.todolist.ToDo;

import java.util.Calendar;


public class CreateToDoFragment extends DialogFragment {

    private TextView dateTextView;
    private EditText titleEditText;
    private EditText detailEditText;
    private Calendar dateAndTime;

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
        dateAndTime=Calendar.getInstance();
        Bundle bundle = this.getArguments();
        dateText= bundle.getString(ARG_TODAY_DATE);
        dateNumericText= bundle.getString(ARG_TODAY_NUMERIC_DATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_create_to_do,null);

        titleEditText=view.findViewById(R.id.titleEditText);
        detailEditText=view.findViewById(R.id.detailEditText);

        dateTextView= view.findViewById(R.id.dateTextView);
        dateTextView.setText(dateText);

        Button calendarDialogBtn = view.findViewById(R.id.calendarDialogBtn);
        calendarDialogBtn.setOnClickListener(v-> {
            selectDate();
        });

        Button applyBtn = view.findViewById(R.id.applyBtn);
        applyBtn.setOnClickListener(v->{
            Intent intent=createIntentBox();
            getTargetFragment().onActivityResult(
                    getTargetRequestCode(), Activity.RESULT_OK,intent);
            getFragmentManager().popBackStack();
        });

        Button closeBtn = view.findViewById(R.id.closeBtn);
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
        if (titleEditText.getText()!=null){
        task.setTitle(titleEditText.getText().toString());
            }else {task.setTitle("Без названия");}

        if (detailEditText.getText()!=null){
        task.setDetail(detailEditText.getText().toString());
        }else {task.setDetail("");}

        task.setDone("0");
        task.setDate(dateNumericText);
        return task;
    }

    public void selectDate() {
        new DatePickerDialog(this.getContext(),mOnDateSetListener,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener mOnDateSetListener= (view, year, month, dayOfMonth) -> {
        dateAndTime.set(Calendar.YEAR,year);
        dateAndTime.set(Calendar.MONTH,month);
        dateAndTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        setInitialDateTime();

    };

    public void setInitialDateTime() {
        dateText= DateUtils.formatDateTime(this.getContext(),
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE| DateUtils.FORMAT_SHOW_YEAR);
        dateTextView.setText(dateText);

        dateNumericText= DateUtils.formatDateTime(this.getContext(),
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_NUMERIC_DATE|DateUtils.FORMAT_SHOW_YEAR);

    }

}