package com.example.todolist.contract;

public interface MainContract {

    interface View{
        void showText(String message);
    }

    interface Presenter{
        void onButtonAddEvent();
        void onDestroy();
    }

    interface Model{
        String loadMessage();
    }
}
