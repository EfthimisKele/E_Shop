package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePelates extends Fragment {

    EditText delete_txt;
    Button deleteUser;

    public DeletePelates() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        delete_txt = view.findViewById(R.id.delete_txt);
        deleteUser = view.findViewById(R.id.deleteUser);
        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_id = 0;
                try {
                     Var_id = Integer.parseInt(delete_txt.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse" + ex);
                }
                Pelates pelates = new Pelates();
                pelates.setId(Var_id);
                MainActivity.myAppDatabase.myDao().deletePelati(pelates);
                Toast.makeText(getActivity(), "Ο λογαριασμός διαγράφθηκε", Toast.LENGTH_LONG).show();
                delete_txt.setText("");
            }
        });
        return view;
    }
}
