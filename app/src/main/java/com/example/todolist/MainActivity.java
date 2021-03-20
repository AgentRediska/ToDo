package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.todolist.contract.MainContract;
import com.example.todolist.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;

    private Button mButton;

    private TextView myTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter =new MainPresenter(this);

        myTv=(TextView)findViewById(R.id.textView);
        mButton=(Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onButtonAddEvent();
            }
        });
    }

    @Override
    public void showText(String message) {
        myTv.setText(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}