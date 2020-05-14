package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProionta extends Fragment {
    //ορισμος μεταβλητων
    EditText e_text1,e_text2,e_text3,e_text4;
    Button submitproion;

    public UpdateProionta() {
        // Required empty public constructorv
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //δημιουργια view και αντιστοιχηση μεταβλητων με τη χρηση της findViewById
        //με τα αναλογα Editext
        View view = inflater.inflate(R.layout.fragment_update_proionta, container, false);
        e_text1 = view.findViewById(R.id.update_textPr1);
        e_text2 = view.findViewById(R.id.update_textPr2);
        e_text3 = view.findViewById(R.id.update_textPr3);
        e_text4 = view.findViewById(R.id.update_textPr4);
        submitproion = view.findViewById(R.id.updatePr);
        submitproion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setOnClickListener στο κουμπι updateproion
                int Var_prid = 0;
                try {
                    Var_prid = Integer.parseInt(e_text1.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                int var_posotita = 0;
                try {
                    var_posotita = Integer.parseInt(e_text2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int var_xronologia = 0;
                try {
                    var_xronologia = Integer.parseInt(e_text3.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int var_timi = 0;
                try {
                    var_timi = Integer.parseInt(e_text4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                //ελεγχος αμα καποιο απο τα 3 πεδια ειναι κενο θα εμφανιζει ενα Toast
                if (var_posotita == 0 || var_xronologia == 0 || var_timi == 0) {
                    String m = "Δεν έβαλες κάποιο πεδίο ";
                    Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();
                } else {
                    try {
                        //Δημιουργια ενος αντικειμενου τυπου Προιοντα
                        //και καλωντας τη μεθοδο addProion γινεται η εισαγωγη
                        //του αντικειμενου με τις  παραπανω μεταβλητες
                        Proionta proionta = new Proionta();
                        proionta.setPid(Var_prid);
                        proionta.setPosotita(var_posotita);
                        proionta.setXronologia(var_xronologia);
                        proionta.setTimi(var_timi);
                        MainActivity.myAppDatabase.myDao().updateProion(proionta);
                        Toast.makeText(getActivity(), "Όλα καλά", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }
                e_text1.setText("");
                e_text2.setText("");
                e_text3.setText("");
                e_text4.setText("");
            }
        });
        return view;
    }
}
