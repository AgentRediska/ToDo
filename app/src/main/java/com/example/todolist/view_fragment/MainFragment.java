package com.example.todolist.view_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.todolist.R;
import com.example.todolist.contract.MainContract;
import com.example.todolist.presenter.MainPresenter;


public class MainFragment extends Fragment implements MainContract.View {

  private MainContract.Presenter mPresenter;

  private Button mButton;
  private Button mButtonAddTask;
  private TextView mTextView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter= new MainPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        mTextView=(TextView)view.findViewById(R.id.dateTextView);

        mButton=(Button)view.findViewById(R.id.calendarBtn);
        mButton.setOnClickListener(v -> mPresenter.onButtonAddEvent());

        mButtonAddTask=(Button)view.findViewById(R.id.addTaskBtn);
        mButtonAddTask.setOnClickListener(v -> {
            FragmentTransaction ftAddFragTasks=getChildFragmentManager().beginTransaction();
            FragmentOfDailyTasks fragmentOfDailyTasks=mPresenter.onCreateFragmentTasks(getTextViewString(mTextView));
            ftAddFragTasks.replace(R.id.container_daily_tasks_fragment,fragmentOfDailyTasks);
            ftAddFragTasks.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ftAddFragTasks.addToBackStack(null);
            ftAddFragTasks.commit();
        });

        return view;
    }

    @Override
    public void showText(String message) {
        mTextView.setText(message);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.onDestroy();
    }


    public String getTextViewString(TextView textView){
        String textViewString=textView.getText().toString();
        return textViewString;
    }
}