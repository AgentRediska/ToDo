package com.example.todolist.view_fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.todolist.R;
import com.example.todolist.ToDo;
import com.example.todolist.contract.MainContract;
import com.example.todolist.presenter.MainPresenter;


public class MainFragment extends Fragment implements MainContract.View {

  private MainContract.Presenter mPresenter;
//first test commit
  private Button mButtonCalendar;
  private Button mButtonAddTask;
  private  FrameLayout createToDoFragmentFL;
  private LinearLayout containerLayout;
  private TextView mTextView;
  private FragmentTransaction ftAddFragTasks;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter= new MainPresenter(this,getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        mTextView=(TextView)view.findViewById(R.id.dateTextView);
        createToDoFragmentFL=(FrameLayout)view.findViewById(R.id.createToDoLayout);
        containerLayout=(LinearLayout)view.findViewById(R.id.containerLayout);

        mPresenter.setInitialDateTime();
        mPresenter.setInitialNumericDateTime();

        mButtonCalendar=(Button)view.findViewById(R.id.calendarBtn);
        mButtonCalendar.setOnClickListener(v -> mPresenter.selectDate());

        mButtonAddTask=(Button)view.findViewById(R.id.addTaskBtn);
        mButtonAddTask.setOnClickListener(v -> {
            //mPresenter.generateToDo();
            containerLayout.setVisibility(View.INVISIBLE);
            createToDoFragmentFL.setVisibility(View.VISIBLE);

            CreateToDoFragment createToDoFragment=mPresenter.onCreateCreateToDoFragment() ;
            createToDoFragment.setTargetFragment(MainFragment.this,120);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.createToDoLayout,createToDoFragment)
                    .addToBackStack(null).commit();
        //v -> replaceFragment()
        });

        replaceFragment();
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        createToDoFragmentFL.setVisibility(View.GONE);
        containerLayout.setVisibility(View.VISIBLE);

        if(requestCode==120){
            if(resultCode== Activity.RESULT_OK){
                //?????????????????? ???????? ?? ???????????? ?? ??????????????????
                containerLayout.setVisibility(View.VISIBLE);
                mPresenter.setTask(  (ToDo) data.getSerializableExtra("NEW_TASK")  );
                replaceFragment();
            }else{
            }
        }
    }

    @Override
    public void showTextDate(String message) {
        mTextView.setText(message);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.onDestroy();
    }

     @Override
    public void replaceFragment(){
        ftAddFragTasks=getChildFragmentManager().beginTransaction();
        FragmentOfDailyTasks fragmentOfDailyTasks=mPresenter.onCreateFragmentTasks();
        ftAddFragTasks.replace(R.id.container_daily_tasks_fragment,fragmentOfDailyTasks);
        ftAddFragTasks.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ftAddFragTasks.addToBackStack(null);
        ftAddFragTasks.commit();
    }



}