package com.example.todolist.view_fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.todolist.R;


public class CreateToDoFragment extends DialogFragment {

    TextView dateTextView;
    Button calendarDialogBtn;

    public CreateToDoFragment() {
        // Required empty public constructor
    }



//    public static CreateToDoFragment newInstance() {
//        CreateToDoFragment fragment = new CreateToDoFragment();
//        Bundle args = new Bundle();
//       // args.putString(ARG_PARAM1, param1);
//       // args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_create_to_do,null);
        dateTextView= view.findViewById(R.id.dateTextView);
        calendarDialogBtn=view.findViewById(R.id.calendarDialogBtn);
        calendarDialogBtn.setOnClickListener(v-> {
            Intent intent=new Intent();
            intent.putExtra("key","hello");
            getTargetFragment().onActivityResult(
                    getTargetRequestCode(), Activity.RESULT_OK,intent);
            getFragmentManager().popBackStack();
        });
        return view;
    }
}