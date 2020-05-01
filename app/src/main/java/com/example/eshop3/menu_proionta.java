package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class menu_proionta extends Fragment  implements  View.OnClickListener{

    Button B_insertPr, B_deletePr, B_editPr;
    public menu_proionta() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_proionta, container, false);

        B_insertPr = view.findViewById(R.id.insertButtonPr);
        B_insertPr.setOnClickListener(this);

        B_deletePr =view.findViewById(R.id.deleteButtonPr);
        B_deletePr.setOnClickListener(this);

        B_editPr =view.findViewById(R.id.editButtonPr);
        B_editPr.setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insertButtonPr:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertProion()).addToBackStack(null).commit();
                break;
            case R.id.deleteButtonPr:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteProionta()).addToBackStack(null).commit();
                break;
            case R.id.editButtonPr:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateProionta()).addToBackStack(null).commit();
                break;
        }


    }}


