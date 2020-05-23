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


public class UpdatePwliseis extends Fragment {

    //ορισμός μεταβλητών
    EditText e1,e2,e3,e4,e5,e6;
    Button updatepwl;


    public UpdatePwliseis() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //δημιουργία View και αντιστοίχηση μεταβλτηών με τα τα κατάλληλα EditText και button
        View view = inflater.inflate(R.layout.fragment_update_pwliseis, container, false);
        e1 = view.findViewById(R.id.update_textPwl1);
        e2 = view.findViewById(R.id.update_textPwl2);
        e3 = view.findViewById(R.id.update_textPwl3);
        e4 = view.findViewById(R.id.update_textPwl4);
        e5 = view.findViewById(R.id.update_textPwl5);
        e6 = view.findViewById(R.id.update_textPwl6);
        updatepwl = view.findViewById(R.id.updatePwl);
        updatepwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parseΙnt για τον κωδικό και toString για τα υπόλοιπα
                int Var_prid = 0;
                try {
                    Var_prid = Integer.parseInt(e1.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                String pwl_name = e2.getText().toString();

                int pwlA = 0;
                try {
                    pwlA = Integer.parseInt(e3.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                int pwlB = 0;
                try {
                    pwlB = Integer.parseInt(e4.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                int pwlC = 0;
                try {
                    pwlC = Integer.parseInt(e5.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                int pwlD = 0;
                try {
                    pwlD = Integer.parseInt(e6.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                if (pwl_name.equals("")) {
                    String m = "Δεν έβαλες όνομα";
                    Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();
                } else {
                    try {
                        //2 λίστες μια ειναι τα προιόντα και η αλλη οι πωλήσεις
                        List<Proionta> proionta1 = MainActivity.myAppDatabase.myDao().getProionta();
                        List<Pwliseis> pwliseis1 = MainActivity.myAppDatabase.myDao().getPwliseis();

                        //αρχικά βρίσκω την εγγραφη αυτης τη πώλησεις μεσα στην λιστα των πωλησεων
                        for (Pwliseis l :pwliseis1) {
                            if (pwl_name.equals(l.getOnoma()) & Var_prid == l.getPpid()) {
                                //για καθε προϊόν που εχω στο πινακα βρισκω τα στοιχεια του.
                                for (Proionta i : proionta1) {
                                    Integer p_id = i.getPid();
                                    Integer posotita = i.getPosotita();
                                    Integer xronologia = i.getXronologia();
                                    Integer timi = i.getTimi();
                                    Integer diafora = 0;
                                    Integer diafora2 = 0;
                                    /* 4 περιπτωσεις που θα κανω τα ιδια πραγματα, γιατι έχω 4 προιόντα,
                                    σε κάθε περίπτωση δηλάδη για καθε προιον, υπάρχουν 3 υποπεριπτώσεις.Σε κάθε
                                    υποπερίπτωση ελέγχω άμα η καινούργια τιμή που έβαλε ο χρήστης είναι μεγαλύτερη από το
                                    απόθεμα του αντίστοιχου προϊόντος , τοτε εμφανίζεται το μήνυμα και δε συνεχίζεται το update
                                    του πίνακα.1η υποπερίπτωση, η καινούργια τιμή που έλαβε ο χρήστης για το προιον είναι μεγαλύτερη
                                    από την προηγούμενη αγορά του,τότε κάνω τη διαφορά μεταξύ τους και τη διαφορά τη αφαιρώ από το απόθεμα του προϊόντος.
                                    2η υποπερίπτωση , η νέα τιμή να είναι μικρότερη από την προηγούμενη , τότε τη διαφορά τους τη προσθέτω στο απόθεμα
                                    του προιοντος και 3ον αμα ειναι ιδια τιμη μη κανεις τιποτα το αποθεμα παραμένει το ίδιο.
                                    Το ιδιο κανω 4 φορές και για 4 προιοντα , Α,Β,Γ,Δ.
                                     */
                                    if (p_id == 1) {
                                        if (pwlA > l.getPosoA()) {
                                            diafora2 = pwlA - l.getPosoA();
                                            diafora = (posotita - diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν Α");
                                            }
                                        }else if (pwlA < l.getPosoA()){
                                            diafora2 = l.getPosoA() - pwlA;
                                            diafora = (posotita + diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν Α");
                                            }
                                        } else if ( pwlA == l.getPosoA()) {
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(posotita);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν Α");
                                            }
                                        }
                                    } else if (p_id == 2) {
                                        if (pwlB > l.getPosoB()){
                                            diafora2 = pwlB - l.getPosoB();
                                            diafora = (posotita - diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν B");
                                            }
                                        }else if (pwlB < l.getPosoB()){
                                            diafora2 = l.getPosoB() - pwlB;
                                            diafora = (posotita + diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν B");
                                            }
                                        }else {
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(posotita);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν B");
                                            }
                                        }
                                    } else if (p_id == 3) {
                                        if(pwlC > l.getPosoC()){
                                            diafora2 = pwlC - l.getPosoC();
                                            diafora = (posotita - diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν C");
                                            }
                                        }else if (pwlC < l.getPosoC()){
                                            diafora2 = pwlC - l.getPosoC();
                                            diafora = (posotita + diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν C");
                                            }
                                        }else {
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(posotita);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν C");
                                            }
                                        }
                                    } else if (p_id == 4) {
                                        if (pwlD > l.getPosoD()) {
                                            diafora2 = pwlD - l.getPosoD();
                                            diafora = (posotita - diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν D");
                                            }
                                        }else if (pwlD < l.getPosoD()){
                                            diafora2 = l.getPosoD() - pwlD;
                                            diafora = (posotita + diafora2);
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(diafora);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν D");
                                            }
                                        } else {
                                            if (diafora >= 0) {
                                                Proionta proionta = new Proionta();
                                                proionta.setPid(p_id);
                                                proionta.setPosotita(posotita);
                                                proionta.setXronologia(xronologia);
                                                proionta.setTimi(timi);
                                                MainActivity.myAppDatabase.myDao().updateProion(proionta);
                                            } else {
                                                throw new Exception("Δεν υπάρχει τόσο απόθεμα στο προϊόν D");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //αφου γινουν ολοι οι σωστοί έλεγχοι γινονται το update της εγγραφης στον πινακα Πωλησεις
                        Pwliseis pwliseis = new Pwliseis();
                        pwliseis.setPpid(Var_prid);
                        pwliseis.setOnoma(pwl_name);
                        pwliseis.setPosoA(pwlA);
                        pwliseis.setPosoB(pwlB);
                        pwliseis.setPosoC(pwlC);
                        pwliseis.setPosoD(pwlD);
                        MainActivity.myAppDatabase.myDao().updatePwliseis(pwliseis);
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
                }}
        });
        return view;
    }
}
