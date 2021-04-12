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


public class CreateToDoFragment extends DialogFragment {

    private TextView dateTextView;
    private Button calendarDialogBtn;
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
            Intent intent=new Intent();
            intent.putExtra("key","hello");
            getTargetFragment().onActivityResult(
                    getTargetRequestCode(), Activity.RESULT_OK,intent);
            getFragmentManager().popBackStack();
        });
        return view;
    }
}