package com.example.todolist.view_fragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todolist.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateToDoDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateToDoDialogFragment extends DialogFragment {


    public CreateToDoDialogFragment() {
        // Required empty public constructor
    }



    public static CreateToDoDialogFragment newInstance() {
        CreateToDoDialogFragment fragment = new CreateToDoDialogFragment();
        Bundle args = new Bundle();
       // args.putString(ARG_PARAM1, param1);
       // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().setTitle(R.string.new_todo_dialog_title);
        View view= inflater.inflate(R.layout.fragment_create_to_do_dialog,null);
        view.findViewById(R.id.dateTextView);
        view.findViewById(R.id.calendarDialogBtn);
        view.setOnClickListener(v-> {
            //wdw
        });

        return inflater.inflate(R.layout.fragment_create_to_do_dialog, container, false);
    }
}