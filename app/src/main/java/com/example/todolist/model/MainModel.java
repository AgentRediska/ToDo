package com.example.todolist.model;

import com.example.todolist.contract.MainContract;

public class MainModel implements MainContract.Model {
    private static final String TAG="MainRepository";

    @Override
    public String loadMessage() {
        return "sasiska";
    }
}
