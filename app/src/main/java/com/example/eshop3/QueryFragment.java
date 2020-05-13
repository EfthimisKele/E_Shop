package com.example.eshop3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class QueryFragment extends Fragment {
    //δηλωση μεταβλητων που θα χρησιμοποιησω
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView querytextView, querytextresult;
    Button B_query_run;
    int test;
    public QueryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //δημιουργια view και αναθεση τιμων σε ενα πινακα τυπου String απο ένα string-array που εχω δηλώσει στο strings.xml
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);

        //αναθεση μεταβλητων με την findViewById
        querytextView = view.findViewById(R.id.qeury_txt2);
        spinner = view.findViewById(R.id.spinner);

        //δημιουργια ενος adapter
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querytextView.setText(queryArray[position]);
                test = position+1;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        querytextresult =view.findViewById(R.id.query_results_txt);
        B_query_run = view.findViewById(R.id.query_button);
        B_query_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querytextresult.setText("test" + test);
                String result="";
                switch (test){
                    case 1:
                        //Παιρνω μια λιστα απο ακαιρεους για αυτο και ResultInt integers
                        //Ετσι με μια αναζητηση και αναλογα το id βρισκω το απόθεμα για κάθε
                        //προιον ξεχωριστα, το ιδιο ισχυει για case 1,2,3,4
                        List<ResultInt> integers = MainActivity.myAppDatabase.myDao().getQuery1();
                        for (ResultInt i: integers) {
                            Integer p_id = i.getField1();
                            Integer posotita = i.getField2();
                            if (p_id == 1){
                                result = result + "\n Το απόθεμα είναι: " + posotita;
                            }
                        }
                        querytextresult.setText(result);
                        break;
                    case 2:
                        List<ResultInt> integers1 = MainActivity.myAppDatabase.myDao().getQuery1();
                        for (ResultInt i: integers1) {
                            Integer p_id = i.getField1();
                            Integer posotita = i.getField2();
                            if (p_id == 2){
                                result = result + "\n Το απόθεμα είναι: " + posotita;
                            }
                        }
                        querytextresult.setText(result);
                        break;
                    case 3:
                        List<ResultInt> integers2 = MainActivity.myAppDatabase.myDao().getQuery1();
                        for (ResultInt i: integers2) {
                            Integer p_id = i.getField1();
                            Integer posotita = i.getField2();
                            if (p_id == 3){
                                result = result + "\n Το απόθεμα είναι: " + posotita;
                            }
                        }
                        querytextresult.setText(result);
                        break;
                    case 4:
                        List<ResultInt> integers4 = MainActivity.myAppDatabase.myDao().getQuery1();
                        for (ResultInt i: integers4) {
                            Integer p_id = i.getField1();
                            Integer posotita = i.getField2();
                            if (p_id==4){
                                result = result + "\n Το απόθεμα είναι: " + posotita;
                            }
                        }
                        querytextresult.setText(result);
                        break;
                    case 5:
                        //παιρνω μια λιστα τυπου Pwliseis και για καθε αντικειμενο Pwliseis εμφανιζω ολα τις στηλες του
                        List<Pwliseis> pwliseis = MainActivity.myAppDatabase.myDao().getPwliseis();
                        for (Pwliseis i: pwliseis){
                            int id = i.getPpid();
                            String name  = i.getOnoma();
                            Integer A = i.getPosoA();
                            Integer B = i.getPosoB();
                            Integer C = i.getPosoC();
                            Integer D = i.getPosoD();
                            result = result + "\n Id:" + id + "\n Όνομα:" + name + "\n Πλήθος προϊόν Α:" + A + "\n Πλήθος προϊόν Β:" + B + "\n Πλήθος προϊόν C:" + C + "\n Πλήθος προϊόν D:" + D;
                        }
                        querytextresult.setText(result);
                        break;
                    case 6:
                        //Βρίσκω τον αριθμό κάθε προιοντος που έχει καταχωρηθει σε καθε καταγραφη στον πινακα Πελατες
                        //και τα προσθέτω. Το ιδιο ισχυει για το το 6,το 7,το 8 και το 9
                        List<Pwliseis> pwliseis2 = MainActivity.myAppDatabase.myDao().getPwliseis();
                        int sum = 0;
                        for (Pwliseis i: pwliseis2) {
                            sum = sum + i.getPosoA();
                        }
                        result = result + "\n Οι συνολικές πωλήσεις είναι " + sum;
                        querytextresult.setText(result);
                        break;
                    case 7:
                        List<Pwliseis> pwliseis3 = MainActivity.myAppDatabase.myDao().getPwliseis();
                        int sum1 = 0;
                        for (Pwliseis i: pwliseis3) {
                            sum1 = sum1 + i.getPosoB();
                        }
                        result = result + "\n Οι συνολικές πωλήσεις είναι " + sum1;
                        querytextresult.setText(result);
                        break;
                    case 8:
                        List<Pwliseis> pwliseis4 = MainActivity.myAppDatabase.myDao().getPwliseis();
                        int sum2 = 0;
                        for (Pwliseis i: pwliseis4) {
                            sum2 = sum2 + i.getPosoC();
                        }
                        result = result + "\n Οι συνολικές πωλήσεις είναι " + sum2;
                        querytextresult.setText(result);
                        break;
                    case 9:
                        List<Pwliseis> pwliseis5 = MainActivity.myAppDatabase.myDao().getPwliseis();
                        int sum3 = 0;
                        for (Pwliseis i: pwliseis5) {
                            sum3 = sum3 + i.getPosoD();
                        }
                        result = result + "\n Οι συνολικές πωλήσεις είναι " + sum3;
                        querytextresult.setText(result);
                        break;
                    case 10:
                        //παιρνω μια λιστα τυπου Pelates και εμφανιζω ενα ενα ολα τα στοιχεια
                        List<Pelates> pelates = MainActivity.myAppDatabase.myDao().getPelates();
                        for (Pelates i: pelates){
                            int id = i.getId();
                            String name = i.getName();
                            String surname = i.getSurname();
                            String poli = i.getPoli();
                            result = result + "\n Id:" + id + "\n Όνομα:" + name + "\n Επίθετο: " + surname + "\n Πόλη: " + poli;
                        }
                        querytextresult.setText(result);
                        break;
                    case 11:
                        //παιρνω μια λιστα τυπου Proionta και εμφανιζω ενα ενα ολα τα στοιχεια
                        List<Proionta> proionta = MainActivity.myAppDatabase.myDao().getProionta();
                        for (Proionta i: proionta){
                            int id = i.getPid();
                            Integer posotita = i.getPosotita();
                            Integer xronologia = i.getXronologia();
                            Integer timi = i.getTimi();
                            result = result + "\n Id:" + id + "\n Απόθεμα:" + posotita + "\n Χρονολογία: " + xronologia + "\n Τιμή: " + timi;
                        }
                        querytextresult.setText(result);
                        break;
                }
            }
        });
        return view;
    }
}
