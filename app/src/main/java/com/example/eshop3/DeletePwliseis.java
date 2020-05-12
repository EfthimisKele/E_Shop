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

public class DeletePwliseis extends Fragment {
    EditText d1,d2,d3,d4,d5,d6;
    Button deletePwl;

    public DeletePwliseis() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_pwliseis, container, false);
        d1 = view.findViewById(R.id.del_textPwl1);
        d2 = view.findViewById(R.id.del_textPwl2);
        d3 = view.findViewById(R.id.del_textPwl3);
        d4 = view.findViewById(R.id.del_textPwl4);
        d5 = view.findViewById(R.id.del_textPwl5);
        d6 = view.findViewById(R.id.del_textPwl6);
        deletePwl = view.findViewById(R.id.deletePwl);
        deletePwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pwl_id = 0;
                try {
                    pwl_id = Integer.parseInt(d1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                String pwl_name = d2.getText().toString();
                int pwlA = 0;
                try {
                    pwlA = Integer.parseInt(d3.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int pwlB = 0;
                try {
                    pwlB = Integer.parseInt(d4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int pwlC = 0;
                try {
                    pwlC = Integer.parseInt(d5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse" + ex);
                }
                int pwlD = 0;
                try {
                    pwlD = Integer.parseInt(d6.getText().toString());
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
                                    diafora = (posotita + pwlA);
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                            }else if (p_id == 2){
                                diafora = (posotita + pwlB);
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                            }else if (p_id == 3){
                                diafora = (posotita + pwlC);
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                            }else if (p_id == 4){
                                diafora = (posotita + pwlD);
                                    Proionta proionta = new Proionta();
                                    proionta.setPid(p_id);
                                    proionta.setPosotita(diafora);
                                    proionta.setXronologia(xronologia);
                                    proionta.setTimi(timi);
                                    MainActivity.myAppDatabase.myDao().updateProion(proionta);
                            }
                        }
                        Pwliseis pwliseis = new Pwliseis();
                        pwliseis.setOnoma(pwl_name);
                        pwliseis.setPosoA(pwlA);
                        pwliseis.setPosoB(pwlB);
                        pwliseis.setPosoC(pwlC);
                        pwliseis.setPosoD(pwlD);
                        pwliseis.setPpid(pwl_id);
                        MainActivity.myAppDatabase.myDao().deletePwliseis(pwliseis);
                        Toast.makeText(getActivity(), "Η αγορά με αυτό το id διαγράφθηκαν", Toast.LENGTH_LONG).show();
                    }catch (Exception e) {
                            String message = e.getMessage();
                            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                  }
                //Στο τελος αδειαζω τα EditText
                d1.setText("");
                d2.setText("");
                d3.setText("");
                d4.setText("");
                d5.setText("");
                d6.setText("");
            }     }
        });
        return view;
    }
}
