package com.example.todolist.presenter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.format.DateUtils;
import android.widget.DatePicker;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.contract.MainContract;
import com.example.todolist.model.MainModel;
import com.example.todolist.view_fragment.FragmentOfDailyTasks;
import com.example.todolist.view_fragment.MainFragment;

import java.util.Calendar;

public class MainPresenter implements MainContract.Presenter {
    FragmentTransaction ftAddFrag;
    private MainContract.View mView;
    private MainContract.Model mModel;
    private Context fragmentContext;

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
    };

    @Override
    public void setDate(String dateText) {
        mView.showTextDate(dateText);
    }


    @Override
    public void setInitialDateTime() {
        String dateText= DateUtils.formatDateTime(fragmentContext,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE| DateUtils.FORMAT_SHOW_YEAR);

        //цифровая дата
        //DateUtils.FORMAT_NUMERIC_DATE|DateUtils.FORMAT_SHOW_YEAR);
        //цифровая дата
        setDate(dateText);
    }

    @Override
    public FragmentOfDailyTasks onCreateFragmentTasks(String date) {
        FragmentOfDailyTasks fragmentOfDailyTasks= FragmentOfDailyTasks.newFragmentOfDailyTasks(date);
        return fragmentOfDailyTasks;
    }

    @Override
    public void onDestroy() {

    }
}
