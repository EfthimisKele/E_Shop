package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//κάνω implements View.OnclickListener ένας άλλος τρόπος αντί να κάνω setOncliCkListener(new View.OnclickListner) σε εάν κουμπί
public class menu_proionta extends Fragment  implements  View.OnClickListener{

    //δημιουργώ 3 μεταβλητές τύπου Button
    Button B_insertPr, B_deletePr, B_editPr;
    public menu_proionta() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //δημιορυγώ το view κάνοντας inflate το αντίστοιχο fragment
        View view = inflater.inflate(R.layout.fragment_menu_proionta, container, false);

        //κάνω αντιστόιχηση τις μεταβλητές μου με τα ανάλογα button
        //χρησιμοποιόντας την findViewById
        //και ορίζω σε κάθε κουμπί την ιδιότητα setOnClickListener(this)
        ///δηλαδή τι θα γίνεται κάθε φορα που κάποιος πατάει κάποιο κουμπί
        B_insertPr = view.findViewById(R.id.insertButtonPr);
        B_insertPr.setOnClickListener(this);
        B_deletePr =view.findViewById(R.id.deleteButtonPr);
        B_deletePr.setOnClickListener(this);
        B_editPr =view.findViewById(R.id.editButtonPr);
        B_editPr.setOnClickListener(this);
        return view;
    }

    //η onClick παίρνει σα παράμετρο τη View που έχω δημιουργήσει και ανάλογα τα id των κουμπιών
    // που έχει η view πάει στο ανόλογο case. Μέσα στο case ανάλογα ποιο κουμπί έχει πατηθεί
    //ξεκινάει μια συναλλαγή και δημιουργεί το αντίστοιχο fragment και με addToBackStack μπορεί
    //κανείς να πηγαίνει πίσω και φυσικά στο τέλος commit.
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


