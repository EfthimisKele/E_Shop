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
    //ορισμος μεταβλητων που θα χρησιμοποιησω
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
        //Δημιουργια view και κάνω την ένωση των μεταβλητων με τα αντιστοιχα elements
        //του fragment χρησιμοποιωντας την findViewById
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
                //setOnClickListener στο κουμπί deletePwl και ελεγχος για καθε μεταβλητη μου
                //αμα υπαρχει ερρορ.
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
                //ελεγχος αμα το ονομα ειναι κενό αλλιως δεν συνεχιζεται η διαδικασια,
                //αμα αφησει κανεις κενα τα πεδια παιρνει σα default το 0, δεν υπαρχει θεμα για
                //τα προιοντα ,για το id μπορει να εχει καποιος το 0
                if (pwl_name.equals("")) {
                    String m = "Δεν έβαλες όνομα";
                    Toast.makeText(getActivity(), m, Toast.LENGTH_LONG).show();
                } else {
                    try {
                        //παιρνω μια λιστα τυπου Προιοντα απο τη myDao
                        //και κανω ενα loop για καθε προιον που εχει αυτη η λιστα
                        //σκοπός είναι σε καθε διαγραφή αγορας το πληθος των προιοντων που αγορασε κανεις
                        //να επιστρεφει στον πινακα Προιοντα.
                        List<Proionta> proionta1 = MainActivity.myAppDatabase.myDao().getProionta();
                        for (Proionta i: proionta1) {
                            //βρισκω και αποθηκευω προσωρινα τις τιμες του καθε στοιχειου απο τη
                            //λιστα τυπου Προιοντα
                            Integer p_id = i.getPid();
                            Integer posotita = i.getPosotita();
                            Integer xronologia = i.getXronologia();
                            Integer timi = i.getTimi();
                            Integer diafora = 0;
                            //στη συνεχεια ελεγχω το p_id αμα ειναι 1 τοτε ειναι το προιον Α
                            //αμα 2 τοτε ειναι το Β κτλ. Οταν μπει σε καποιο απο τα if
                            //στη λιστα του πινακα που εχει το αποθεμα καθε προιοντος
                            //προσθετεται και η ποσοτητα που ειχε παραγγειλει ο πελατης.
                            //Και καλειται η μεθοδος updateProion για να γινει update
                            //ο πινακας.
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
                        //Δημιουργια αντικειμενου τυπου Pwliseis
                        //κανω αντιστοιχηση με τις τιμες των EditText
                        //και καλω τη deletePwliseis για να γινει η καταλληλη διαγραφή
                        //στον πινακα αφου εχει γινει επιβαιβεωσει της αγορας και εχουν επιστραφεί
                        //τα προιοντα
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
