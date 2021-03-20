package com.example.todolist.view_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todolist.R;


public class FragmentOfDailyTasks extends Fragment {

    private static final String ARG_DATE="date";
    private Bundle mBundle;
    public static FragmentOfDailyTasks newFragmentOfDailyTasks(String date){
        Bundle args= new Bundle();
        args.putString(ARG_DATE,date);
        FragmentOfDailyTasks fragmentOfDailyTasks=new FragmentOfDailyTasks();
        fragmentOfDailyTasks.setArguments(args);
        return fragmentOfDailyTasks;
    }

    public FragmentOfDailyTasks() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle=this.getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_of_daily_tasks, container, false);

        TextView testTextDate=(TextView)view.findViewById(R.id.testTextViewDate);

        testTextDate.setText(mBundle.getString(ARG_DATE));
        return view;
    }
}