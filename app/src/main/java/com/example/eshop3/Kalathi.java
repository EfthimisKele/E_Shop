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

import java.util.List;

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
                int pwl_id = 0;
                try {
                    pwl_id = Integer.parseInt(k1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                String pwl_name = k2.getText().toString();

                int pwlA = 0;
                try {
                    pwlA = Integer.parseInt(k3.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int pwlB = 0;
                try {
                    pwlB = Integer.parseInt(k4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int pwlC = 0;
                try {
                    pwlC = Integer.parseInt(k5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int pwlD = 0;
                try {
                    pwlD = Integer.parseInt(k6.getText().toString());
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
                        pwliseis.setPososD(pwlD);
                        MainActivity.myAppDatabase.myDao().addPwliseis(pwliseis);
                        Toast.makeText(getActivity(), "Όλα καλά", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    //Στο τελος αδειαζω τα TextView
                    k1.setText("");
                    k2.setText("");
                    k3.setText("");
                    k4.setText("");
                    k5.setText("");
                    k6.setText("");
                }
            }});
        return view;
    }


}
