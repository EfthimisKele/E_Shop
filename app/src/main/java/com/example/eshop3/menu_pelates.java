package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class menu_pelates extends Fragment implements View.OnClickListener {

     Button B_insert, B_delete, B_edit;
    public menu_pelates() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_pelates, container, false );

        B_insert =view.findViewById(R.id.insertButton);
        B_insert.setOnClickListener(this);
        B_delete =view.findViewById(R.id.deleteButton);
        B_delete.setOnClickListener(this);
        B_edit =view.findViewById(R.id.editButton);
        B_edit.setOnClickListener(this);
        return view;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.insertButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new InsertPelates()).addToBackStack(null).commit();
                break;
            case R.id.deleteButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeletePelates()).addToBackStack(null).commit();
                break;
            case R.id.editButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdatePelates()).addToBackStack(null).commit();
                break;
        }
    }
}
