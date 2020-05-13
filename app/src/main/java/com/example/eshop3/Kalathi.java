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

    //ορισμος μεταβλητων
    EditText k1,k2,k3,k4,k5,k6;
    Button k7;
    public Kalathi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //δημιουργια view
        //και αντιστοιχηση μεταβλτηων με τη χρηση findViewById
        View view = inflater.inflate(R.layout.fragment_kalathi, container, false);
        k1 = view.findViewById(R.id.edit_kalathi);
        k2 = view.findViewById(R.id.edit_kalathi2);
        k3 = view.findViewById(R.id.proionA);
        k4 = view.findViewById(R.id.proionB);
        k5 = view.findViewById(R.id.proionC);
        k6 = view.findViewById(R.id.proionD);
        k7 = view.findViewById(R.id.submit_Kalathi_agora);

        // to bundle παιρνει τιμες απο το getArguments
        //και στη συνεχεια το αποθηκευω σε ενα πινακα τυπου String
        Bundle bundle = getArguments();
        String m[] = bundle.getStringArray("tra");

        //ενα ενα τα στοιχεια του πινακα που δημιουργισα πιο πανω τον οποιο τον πηρα
        //απο το Agora_fragmen τα βαζω στα editText ένα ένα.
        k3.setText(m[0]);
        k4.setText(m[1]);
        k5.setText(m[2]);
        k6.setText(m[3]);
        k7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //η συνέχει ειναι ίδια με το InsertPwliseis καθως εκτελείται η ίδια διαδικασία εισαγωγής.
                //κανοντας parseInt αποθηκευεω τις τιμες των EditText σε μορφη Integer
                //και toString για το ονομα
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
                    String m = "Δεν έβαλες κάποιο πεδίο";
                    Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();
                } else {
                    try {
                         /*
                        Παιρνω μια λιστα τυπου Προιοντα καθως θα θελω να ελεγχω καθε φορα
                        αμα το αποθεμα ειναι αρκετο να καλυψει το πληθος που θελει ο χρηστης.
                        Ετσι στην αρχη για το προιον τυπου Α με p_id=1 , αφου βρω ποσο αποθεμα εχει
                        κανω μια αφαιρεση με το πληθος που επιθυμει να αγορασει ο χρηστης. Αμα η διαφορα
                        ειναι θετικη τοτε συνεχιζει ο κωδικας και γινεται ενα update στον πινακα Proionta
                        καλωντας την updateProion.To ιδιο συμβαινει και για το προιον , τυπου Β,C,D με p_id
                        2,3,4 αντιστοιχα.
                         */
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
