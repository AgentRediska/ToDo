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
    private String dateNumericText;

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
        String dateText= DateUtils.formatDateTime(fragmentContext,
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
    public void generateToDo() {
        mModel.addToDoTask(fragmentContext,"07.04.2021","Помыть посуду",0,"бла бла бла");
        mModel.addToDoTask(fragmentContext,"05.04.2021","Сделать пары",0,"блак блак блак");
        mModel.addToDoTask(fragmentContext,"05.04.2021","Пойти спать",0,"бу бу бу бу");
    }

    @Override
    public FragmentOfDailyTasks onCreateFragmentTasks() {
        FragmentOfDailyTasks fragmentOfDailyTasks= FragmentOfDailyTasks.newFragmentOfDailyTasks(dateNumericText);
        return fragmentOfDailyTasks;
    }

    @Override
    public void onDestroy() {

    }
}
