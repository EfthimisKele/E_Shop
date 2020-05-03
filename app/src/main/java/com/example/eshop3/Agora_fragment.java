package com.example.eshop3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Agora_fragment extends Fragment  implements View.OnClickListener{

    //Δηλώνω τισ μεταβλητές που θα χρησιμοποιήσω
    static EditText  p1,p2,p3,p4;
    Button a1,a2,a3,a4,kalathi1;

    // μεταβλητή τύπου OnMessageSendListener και με το ανόλογο interface που παίρνει σα παράμετρο
    // ένα πίνακα τύπου String, καθώς θα περνάω τα Strings από 4 EditText σε 4 TextView αντίστοιχα
    OnMessageSendListener messageSendListener;
    public interface OnMessageSendListener{
        public void onMessageSend(String m[]);
    }

    public Agora_fragment(){
        //Emprty constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // δημιουργώ το view κάνοντας inflate το fragment
        View view = inflater.inflate(R.layout.fragment_agora, container, false );

        // κάνω αντιστοίχηση στις μεταβλητές που έχω δηλώσει με τα αντικείμενα του layout μου
        // χρησιμοποιόντας το findViewById
        a1 = view.findViewById(R.id.prosthikiA);
        a1.setOnClickListener(this);
        a2 = view.findViewById(R.id.prosthikiB);
        a2.setOnClickListener(this);
        a3 = view.findViewById(R.id.prosthikiC);
        a3.setOnClickListener(this);
        a4 = view.findViewById(R.id.prosthikiD);
        a4.setOnClickListener(this);
        p1 = view.findViewById(R.id.textproionA);
        p2 = view.findViewById(R.id.textproionB);
        p3 = view.findViewById(R.id.textproionC);
        p4 = view.findViewById(R.id.textproionD);

        // μετατρέπω σε String τις τιμές από τα EditText και τα βάζω σε ένα String πίνακα
        String a = p1.getText().toString();
        String b = p2.getText().toString();
        String c = p3.getText().toString();
        String d = p4.getText().toString();
        String[] k = {a, b, c, d};

        kalathi1 = view.findViewById(R.id.submit_kalathi);
        kalathi1.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        String a = p1.getText().toString();
        String b = p2.getText().toString();
        String c = p3.getText().toString();
        String d = p4.getText().toString();
        String[] k = {a, b, c, d};


        switch (v.getId()){
            case R.id.prosthikiA:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_SHORT).show();
                break;
            case R.id.prosthikiB:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_SHORT).show();
                break;
            case R.id.prosthikiC:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_SHORT).show();
                break;
            case R.id.prosthikiD:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submit_kalathi:
                messageSendListener.onMessageSend(k);
                break;
        }
    }

    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            messageSendListener = (OnMessageSendListener) activity;
        }catch (ClassCastException e){
            throw  new ClassCastException((activity.toString()+"must override on MessageRead..."));
        }
    }
}
