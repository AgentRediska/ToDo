package com.example.todolist.model;

import com.example.todolist.contract.DailyTasksFragmentContract;

public class DailyTasksFragmentModel implements DailyTasksFragmentContract.Model {
    @Override
    public String loadMessage() {
        String testText="hello";
        return testText;
    }
}
