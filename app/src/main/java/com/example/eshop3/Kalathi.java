package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Kalathi extends Fragment  {

    EditText k1,k2,a1,a2,a3,a4;
    TextView k3,k4,k5,k6;
    Button k7;


    public Kalathi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kalathi, container, false);
        k1 = view.findViewById(R.id.edit_kalathi);
        k2 = view.findViewById(R.id.edit_kalathi2);
        k3 = view.findViewById(R.id.proionA);
        k4 = view.findViewById(R.id.proionB);
        k5 = view.findViewById(R.id.proionC);
        k6 = view.findViewById(R.id.proionD);
        k7 = view.findViewById(R.id.submit_Kalathi_agora);
        Bundle bundle = getArguments();
        String m = bundle.getString("m");
        k3.setText(m);
        k7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });






        return view;
    }


}
