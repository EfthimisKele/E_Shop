package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class InsertPwliseis extends Fragment {

    EditText e1,e2,e3,e4,e5,e6;
    Button submitpwl;

    public InsertPwliseis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_pwliseis, container, false);
        e1 = view.findViewById(R.id.edit_textPwl1);
        e2 = view.findViewById(R.id.edit_textPwl2);
        e3 = view.findViewById(R.id.edit_textPwl3);
        e4 = view.findViewById(R.id.edit_txtPwl4);
        e5 = view.findViewById(R.id.edit_textPwl5);
        e6 = view.findViewById(R.id.edit_textPwl6);
        submitpwl = view.findViewById(R.id.submitPwl);
        submitpwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pwl_id = 0;
                try {
                    pwl_id = Integer.parseInt(e1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }

                String pwl_name = e2.getText().toString();

                int pwlA = 0;
                try {
                    pwlA = Integer.parseInt(e3.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }

                int pwlB = 0;
                try {
                    pwlB = Integer.parseInt(e4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }

                int pwlC = 0;
                try {
                    pwlC = Integer.parseInt(e5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }

                int pwlD = 0;
                try {
                    pwlD = Integer.parseInt(e6.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                if (pwl_name.equals("")) {
                    String m = "Δεν έβαλες όνομα";
                    Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();
                } else {
                    try {
                        List<Proionta> proionta1 = MainActivity.myAppDatabase.myDao().getProionta();
                        for (Proionta i: proionta1) {
                            Integer p_id = i.getPid();
                            Integer posotita = i.getPosotita();
                            Integer xronologia = i.getXronologia();
                            Integer timi = i.getTimi();
                            Integer diafora = 0;
                            if (p_id == 1) {
                                diafora = (posotita - pwlA);
                                if (diafora >= 0 ) {
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                }else{
                                    throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν Α");
                                }
                            }else if (p_id == 2){
                                diafora = (posotita - pwlB);
                                if (diafora >= 0 ) {
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                }else{
                                    throw new Exception();
                                }
                            }else if (p_id == 3){
                                diafora = (posotita - pwlC);
                                if (diafora >= 0 ) {
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                }else{
                                    throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν C");
                                }
                            }else if (p_id == 4){
                                diafora = (posotita - pwlD);
                                if (diafora >= 0 ) {
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                }else{
                                    throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν Δ");
                                }
                            }
                        }
                        Pwliseis pwliseis = new Pwliseis();
                        pwliseis.setPpid(pwl_id);
                        pwliseis.setOnoma(pwl_name);
                        pwliseis.setPosoA(pwlA);
                        pwliseis.setPosoB(pwlB);
                        pwliseis.setPosoC(pwlC);
                        pwliseis.setPosoD(pwlD);
                        MainActivity.myAppDatabase.myDao().addPwliseis(pwliseis);
                        Toast.makeText(getActivity(), "Όλα καλά", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    //Στο τελος αδειαζω τα EditText
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                    e6.setText("");
                }
                }});
        return view;
    }
}
