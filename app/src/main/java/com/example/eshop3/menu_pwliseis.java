package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class menu_pwliseis extends Fragment implements View.OnClickListener{

    Button b1,b2,b3;
    public menu_pwliseis() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_pwliseis, container, false);

        b1 = view.findViewById(R.id.insertButtonPwl);
        b1.setOnClickListener(this);

        b2 = view.findViewById(R.id.deleteButtonPwl);
        b2.setOnClickListener(this);

        b3 =view.findViewById(R.id.editButtonPwl);
        b3.setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insertButtonPwl:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertPwliseis()).addToBackStack(null).commit();
                break;
            case R.id.deleteButtonPwl:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeletePwliseis()).addToBackStack(null).commit();
                break;
            case R.id.editButtonPwl:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdatePwliseis()).addToBackStack(null).commit();
                break;
        }
    }}
