package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertProion extends Fragment {

    //ορισμος μεταβλητων
    EditText e_text1,e_text2,e_text3,e_text4;
    Button submitproion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //δημιουργια view αντιστοιχηση των EditText και του Button με τις μεταβλητες που εχω δηλωσει
        View view = inflater.inflate(R.layout.fragment_insert_proion, container, false);
        e_text1 = view.findViewById(R.id.edit_textPr1);
        e_text2 = view.findViewById(R.id.edit_textPr2);
        e_text3 = view.findViewById(R.id.edit_textPr3);
        e_text4 = view.findViewById(R.id.edit_textPr4);
        submitproion = view.findViewById(R.id.submitproion);
        submitproion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setOnClickListener στο κουμπί submitproion
                //και ελεγχος για τιμή μου μην βγαζει ερρορ με το σωστο Format που πρεπει να εχει
                int Var_prid = 0;
                try {
                    Var_prid = Integer.parseInt(e_text1.getText().toString());
                } catch (NumberFormatException ex) {
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
                        MainActivity.myAppDatabase.myDao().addProion(proionta);
                        Toast.makeText(getActivity(), "Όλα καλά", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    //τελος αειαζω τις τιμες των EditText
                    e_text1.setText("");
                    e_text2.setText("");
                    e_text3.setText("");
                    e_text4.setText("");
                }
            }});
        return view;
    }
}
