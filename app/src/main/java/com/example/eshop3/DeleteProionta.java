package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteProionta extends Fragment {

    //ορισμος μεταβλητων που θα χρησιμοποιησω
    EditText delete_txtpr;
    Button deletePr;

    public DeleteProionta() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Δημιουργια view και κάνω την ένωση των μεταβλητων με τα αντιστοιχα elements
        //του fragment χρησιμοποιωντας την findViewById
        View view = inflater.inflate(R.layout.fragment_delete_proionta, container, false);
        delete_txtpr = view.findViewById(R.id.delete_txtPr);
        deletePr = view.findViewById(R.id.deletePr);
        deletePr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setOnClickListener στο κουμπί deletePr, δηλαδη τι θα γινει οταν παταει κανεις το κουμπι
                //Παιρνω την Integer τιμή του EditText, ελέγχω για ερρορ και αμα πανε ολα καλα
                //Δημιουργω ενα εντικειμενο της κλασης Proionta, του δινω το id που βρηκα πριν λιγο
                //και καλωντας τη μεθοδο deleteProion που την εχω ορισει στο MyDao γίνεται η αντίστοιχη
                //διαγραφή Προιον.Τελος εμφανιζω ενα Toast και μηδενιζω τη τιμή του EditText
                int Var_prid = 0;
                try {
                    Var_prid = Integer.parseInt(delete_txtpr.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                Proionta proionta = new Proionta();
                proionta.setPid(Var_prid);
                MainActivity.myAppDatabase.myDao().deleteProion(proionta);
                Toast.makeText(getActivity(), "Το προιον διαγράφθηκε", Toast.LENGTH_LONG).show();
                delete_txtpr.setText("");
            }
        });
        return view;
    }
}
