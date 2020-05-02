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

public class Agora_fragment extends Fragment {

    static EditText  p1,p2,p3,p4;
    Button a1,a2,a3,a4,kalathi1;
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
        View view = inflater.inflate(R.layout.fragment_agora, container, false );

        a1 = view.findViewById(R.id.prosthikiA);
        a2 = view.findViewById(R.id.prosthikiB);
        a3 = view.findViewById(R.id.prosthikiC);
        a4 = view.findViewById(R.id.prosthikiD);
        p1 = view.findViewById(R.id.textproionA);
        p2 = view.findViewById(R.id.textproionB);
        p3 = view.findViewById(R.id.textproionC);
        p4 = view.findViewById(R.id.textproionD);
        String a = p1.getText().toString();
        String b = p2.getText().toString();
        String c = p3.getText().toString();
        String d = p4.getText().toString();
        String[] k = {a, b, c, d};

        kalathi1 = view.findViewById(R.id.submit_kalathi);
        kalathi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = p1.getText().toString();
                String b = p2.getText().toString();
                String c = p3.getText().toString();
                String d = p4.getText().toString();
                String[] k = {a, b, c, d};

                
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
                        messageSendListener.onMessageSend(k);
                        break;
                }
           }
        });
        return view;
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
