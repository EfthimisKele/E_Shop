package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Agora_fragment extends Fragment implements View.OnClickListener {

    static EditText  p1,p2,p3,p4;
    Button a1,a2,a3,a4,kalathi1;
    static String m1  ;

    OnMessageSendListener messageSendListener;
    public interface OnMessageSendListener{
        public void onMessageSend( final String m);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agora, container, false );

        a1 = view.findViewById(R.id.prosthikiA);
        a1.setOnClickListener(this);
        a2 = view.findViewById(R.id.prosthikiB);
        a2.setOnClickListener(this);
        a3 =view.findViewById(R.id.prosthikiC);
        a3.setOnClickListener(this);
        a4 = view.findViewById(R.id.prosthikiD);
        a4.setOnClickListener(this);
        kalathi1 =view.findViewById(R.id.submit_kalathi);
        kalathi1.setOnClickListener(this);
        p1 = view.findViewById(R.id.textproionA);
        p2 = view.findViewById(R.id.textproionB);
        p3 = view.findViewById(R.id.textproionC);
        p4 = view.findViewById(R.id.textproionD);
        p1.setOnClickListener(this);
        p2.setOnClickListener(this);
        p3.setOnClickListener(this);
        p4.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
       // final EditText p1;
       // final String m1;
      //  p1 = v.findViewById(R.id.textproionA);

       // m1 = p1.getText().toString();

        switch (v.getId()){
            case R.id.prosthikiA:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_LONG).show();
                break;
            case R.id.prosthikiB:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_LONG).show();
                break;
            case R.id.prosthikiC:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_LONG).show();
                break;
            case R.id.prosthikiD:
                Toast.makeText(getActivity(), "Έγινε η προσθήκη στο καλάθι", Toast.LENGTH_LONG).show();
                break;
            case R.id.submit_kalathi:
             //   messageSendListener.onMessageSend("m");
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Kalathi()).addToBackStack(null).commit();
                break;
        }
    }
}
