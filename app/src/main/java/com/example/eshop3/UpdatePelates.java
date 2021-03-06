package com.example.eshop3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class UpdatePelates extends Fragment {
    //ορισμος μεταβλητων
    EditText update_text1, update_text2, update_text3, update_text4;
    Button updatetuser;

    public UpdatePelates() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //δημιουργια view και αντιστοιχηση μεταβλητων με τη χρηση της findViewById
        //με τα αναλογα Editext
        View view = inflater.inflate(R.layout.fragment_update_pelates, container, false);
        update_text1 = view.findViewById(R.id.update_text1);
        update_text2 = view.findViewById(R.id.update_text2);
        update_text3 = view.findViewById(R.id.update_text3);
        update_text4 = view.findViewById(R.id.update_text4);
        updatetuser = view.findViewById(R.id.updateuser);
        updatetuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setOnClickListener στο κουμπι updateuser
                int Var_id = 0;
                try {
                    Var_id = Integer.parseInt(update_text1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                String Var_name = update_text2.getText().toString();
                String Var_surname = update_text3.getText().toString();
                String Var_poli = update_text4.getText().toString();

                //ελεγχος αμα καποιο απο τα 3 πεδια εκτος του id ειναι κενο τοτε εμφανιζει καταλληλο μηνυμα
                if(Var_name.equals("")  || Var_surname.equals("") || Var_poli.equals("") ){
                    String m = "Δεν έβαλες κάποιο πεδίο";
                    Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();
                }else{
                    try {
                        //αν ειναι ολα καλα , δημιουργω νεο αντικειμεο τυπου Πελατες
                        //εισαγω σε αυτην την εγγραφη ενα ενα τα παραπανω στοιχεια απο τα EditText
                        //και καλω την συναρτηση addPelati που την εχω ορισει στο myDao
                        //αλλιως πεταει ερρορ οτι δεν μπορει να γινει η εγγραφη στον πινακα
                        Pelates pelates = new Pelates();
                        pelates.setId(Var_id);
                        pelates.setName(Var_name);
                        pelates.setSurname(Var_surname);
                        pelates.setPoli(Var_poli);
                        MainActivity.myAppDatabase.myDao().updatePelati(pelates);
                        Toast.makeText(getActivity(), "Όλα καλά", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    //καθαριαζω τα editText και τα κανω κενα
                    update_text1.setText("");
                    update_text2.setText("");
                    update_text3.setText("");
                    update_text4.setText("");
                }

            }
        });
        return view;
    }
}