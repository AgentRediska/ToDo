package com.example.todolist.view_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.todolist.R;
import com.example.todolist.contract.DailyTasksFragmentContract;
import com.example.todolist.presenter.DailyTasksFragmentPresenter;


public class FragmentOfDailyTasks extends Fragment implements DailyTasksFragmentContract.View{

    private static final String ARG_DATE="date";
    private Bundle mBundle;

    private DailyTasksFragmentContract.Presenter mPresenter;

    private Button btn_complete_all;
    private Button btn_delete_all;


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
        mPresenter=new DailyTasksFragmentPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_of_daily_tasks, container, false);

        btn_complete_all=(Button)view.findViewById(R.id.btn_complete_all);
        btn_complete_all.setOnClickListener(v -> mPresenter.onButtonCompleteAllEvent());

        btn_delete_all=(Button)view.findViewById(R.id.btn_delete_all);
        btn_delete_all.setOnClickListener(v -> mPresenter.onButtonDeleteAllEvent());

        //будет удалено
        TextView testTextDate=(TextView)view.findViewById(R.id.testTextViewDate);
        testTextDate.setText(mBundle.getString(ARG_DATE));
        //будет удалено

        return view;
    }
}