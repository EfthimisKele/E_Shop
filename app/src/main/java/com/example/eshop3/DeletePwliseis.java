package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePwliseis extends Fragment {
    EditText delete_txtpr;
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
        delete_txtpr = view.findViewById(R.id.delete_txtPwl);
        deletePwl = view.findViewById(R.id.deletePwl);
        deletePwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_ppid = 0;
                try {
                    Var_ppid = Integer.parseInt(delete_txtpr.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                Pwliseis pwliseis = new Pwliseis();
                pwliseis.setPpid(Var_ppid);
                MainActivity.myAppDatabase.myDao().deletePwliseis(pwliseis);
                Toast.makeText(getActivity(), "Η αγορές με αυτό το id διαγράφθηκαν", Toast.LENGTH_LONG).show();
                delete_txtpr.setText("");
            }
        });
        return view;
    }
}
