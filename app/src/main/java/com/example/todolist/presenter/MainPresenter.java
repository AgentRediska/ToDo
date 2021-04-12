package com.example.todolist.presenter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.format.DateUtils;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.ToDo;
import com.example.todolist.contract.MainContract;
import com.example.todolist.model.MainModel;
import com.example.todolist.view_fragment.CreateToDoFragment;
import com.example.todolist.view_fragment.FragmentOfDailyTasks;
import com.example.todolist.view_fragment.MainFragment;

import java.util.Calendar;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private MainContract.Model mModel;
    private Context fragmentContext;
    private String dateNumericText;
    private String dateText;

    private Calendar dateAndTime=Calendar.getInstance();

    public MainPresenter(MainContract.View mView,Context context){
        this.fragmentContext=context;
        this.mView=mView;
        this.mModel= new MainModel();


    }

    @Override
    public void selectDate() {
        new DatePickerDialog(fragmentContext,mOnDateSetListener,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener mOnDateSetListener= (view, year, month, dayOfMonth) -> {
        dateAndTime.set(Calendar.YEAR,year);
        dateAndTime.set(Calendar.MONTH,month);
        dateAndTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        setInitialDateTime();
        setInitialNumericDateTime();
        mView.replaceFragment();
    };

    @Override
    public void setInitialDateTime() {
        dateText= DateUtils.formatDateTime(fragmentContext,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE| DateUtils.FORMAT_SHOW_YEAR);
        setDate(dateText);

    }

    @Override
    public void setInitialNumericDateTime() {
        dateNumericText= DateUtils.formatDateTime(fragmentContext,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_NUMERIC_DATE|DateUtils.FORMAT_SHOW_YEAR);
    }

    @Override
    public void setDate(String dateText) {
        mView.showTextDate(dateText);
    }

    @Override
    public void setTask(ToDo task) {
          mModel.addToDoTask(fragmentContext, task.getDate(),task.getTitle(),task.getDetail());
    }

    @Override
    public FragmentOfDailyTasks onCreateFragmentTasks() {
        FragmentOfDailyTasks fragmentOfDailyTasks= FragmentOfDailyTasks.newFragmentOfDailyTasks(dateNumericText);
        return fragmentOfDailyTasks;
    }

    @Override
    public CreateToDoFragment onCreateCreateToDoFragment() {
        CreateToDoFragment createToDoFragment=CreateToDoFragment.newInstance(dateText,dateNumericText);
        return createToDoFragment;
    }

    @Override
    public void onDestroy() {

    }
}
