package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//κάνω implements View.OnclickListener ένας άλλος τρόπος αντί να κάνω setOncliCkListener(new View.OnclickListner) σε εάν κουμπί
public class menu_pwliseis extends Fragment implements View.OnClickListener{

    //δημιουργώ 3 μεταβλητές τύπου Button
    Button b1,b2,b3;
    public menu_pwliseis() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //δημιορυγώ το view κάνοντας inflate το αντίστοιχο fragment
        View view = inflater.inflate(R.layout.fragment_menu_pwliseis, container, false);

        //κάνω αντιστόιχηση τις μεταβλητές μου με τα ανάλογα button
        //χρησιμοποιόντας την findViewById
        //και ορίζω σε κάθε κουμπί την ιδιότητα setOnClickListener(this)
        ///δηλαδή τι θα γίνεται κάθε φορα που κάποιος πατάει κάποιο κουμπί
        b1 = view.findViewById(R.id.insertButtonPwl);
        b1.setOnClickListener(this);
        b2 = view.findViewById(R.id.deleteButtonPwl);
        b2.setOnClickListener(this);
        b3 =view.findViewById(R.id.editButtonPwl);
        b3.setOnClickListener(this);
        return view;
    }

    //η onClick παίρνει σα παράμετρο τη View που έχω δημιουργήσει και ανάλογα τα id των κουμπιών
    // που έχει η view πάει στο ανόλογο case. Μέσα στο case ανάλογα ποιο κουμπί έχει πατηθεί
    //ξεκινάει μια συναλλαγή και δημιουργεί το αντίστοιχο fragment και με addToBackStack μπορεί
    //κανείς να πηγαίνει πίσω και φυσικά στο τέλος commit.
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
