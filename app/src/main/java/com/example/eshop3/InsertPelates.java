package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InsertPelates extends Fragment {

     EditText edit_text1,edit_text2,edit_text3,edit_text4;
     Button submituser;

    public InsertPelates() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_pelates, container, false);
        edit_text1 = view.findViewById(R.id.edit_text1);
        edit_text2 = view.findViewById(R.id.edit_text2);
        edit_text3 = view.findViewById(R.id.edit_text3);
        edit_text4 = view.findViewById(R.id.edit_text4);
        submituser = view.findViewById(R.id.submituser);
        submituser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_id = 0;
                try {
                    Var_id = Integer.parseInt(edit_text1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                String Var_name = edit_text2.getText().toString();
                String Var_surname = edit_text3.getText().toString();
                String Var_poli = edit_text4.getText().toString();

              if(Var_name.equals("")  || Var_surname.equals("") || Var_poli.equals("") ){
                  String m = "Δεν έβαλες κάποιο πεδίο";
                  Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();
                }else{
                    try {
                        Pelates pelates = new Pelates();
                        pelates.setId(Var_id);
                        pelates.setName(Var_name);
                        pelates.setSurname(Var_surname);
                        pelates.setPoli(Var_poli);
                        MainActivity.myAppDatabase.myDao().addPelati(pelates);
                        Toast.makeText(getActivity(), "Όλα καλά", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    edit_text1.setText("");
                    edit_text2.setText("");
                    edit_text3.setText("");
                    edit_text4.setText("");

                } }});
        return view;
    }
    }
