package com.example.eshop3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;

//Αρχικά η κλάση μου κάνει implements το interface που έχω δημιουργήσει στη κλάση Agora_fragment
public class MainActivity extends AppCompatActivity implements Agora_fragment.OnMessageSendListener {

    //Δηλώνω τις μεταβλητές που θα χρησιμοποιήσω για το project μου όπως ,ένα custom toolbar,
    //drawerlayout και navigationview όπως μας ζητήθηκε , myAppDatabase για τη δημιουργία της βάσης μου
    //και fragmentManager τυπου FragmentManager για να μπορώ να κάνω εναλλαγή στα fragments του project.

     Toolbar toolbar;
     DrawerLayout drawerLayout;
     NavigationView navigationView;
     public static MyAppDatabase myAppDatabase;
     public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //όπως είναι από την αρχή
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //δημιουργω την βάση μου και θέτω τη τιμή στο fragmentManger με getSupportFragmentManager
        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "UserBD").allowMainThreadQueries().build();


        //βαζω πρωτο fragment που θα εμφανιζεται το home_fragment αφού ελέγξω το savedInstanceState είναι ίσο με null
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_fragment()).commit();
        }

        //βρισκω και βαζω toolbar αυτο που εχω δημιουργήσει
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // βρίσκω το drawerlayout και το navigationview και δίνω εντολές σε ποιο
        // fragment θα πηγαινει κανείς πατωντας μια επιλογή από το μενού
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        //ελέγχει την τιμή του κάθε item που βρίσκεται στο μενού του DrawerLayout και ανάλογα σε ποιο πατάει ο χρήστης
                        //τον πηγαείνει στο αντίστοιχο case. Έπειτα θέτει το item που πάπτησε σε επιλογή ότι είναι πατημένο, ξεκινάει
                        //ένα transaction όπου αντιστοιχεί το fragment_container δηλαδή το fragment της main με το ανάλογο fragment.
                        //Και κλείνει το menu DrawerLayout.Το ίδιο συμβαίνει σε όλα τα cases.
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_fragment()).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.logariasmos:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new menu_pelates()).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.proionta:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new menu_proionta()).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.pwliseis:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new menu_pwliseis()).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.agora:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Agora_fragment()).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.search:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new QueryFragment()).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.about:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new about_fragment()).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                }
            }
        });
    }
    /*Εδώ δημιουργώ τη μέθοδο που θα χρησιμοποίησω ανάμεσα στα fragment Agora με Kalathi.
      Είναι μια μέθοδος όπου παίρνει την τιμή ενός πίνακα τύπου String. Μέσα στη μέθοδο
      δημιουργεί ένα νέο στοιχείο τύπου Kalathi δηλάδή της κλάσης μου και ένα νέο στοιχείο
      τύπου Bundle όπου με την κατάλληλη εντολή putStringArray και κλειδί "tra" βάζω στο bundle
      το πίνακα που είχα σα παράμετρο στη μέθοδο. Στη μεταβλητή kalathi τύπου Kalathi κάνω setArguments
      το bundle που το έχω δώσει τιμή ενός πίνακα. Στη συνέχεια ξεκινάω μια συναλλαγή όπου βάζω στη θέση του
      fragment_container το kalathi που έχω δημιουργήσει. Με το addToBackStack μπορεί ο χρήστης να πάει πίσω
      στο προηγούμενο fragment και στο τελός ένα commit. Ουσιαστικά έχω δημιουργήσει μια μέθοδο η οποία με
      δημιουργεί και με πάει σε ένα καινούργιο fragment στο οποίο έχω μεταφέρει έναν πίνακα τύπου String
      από ένα άλλο fragment.
     */
        public void onMessageSend(String[] m){
            Kalathi kalathi = new Kalathi();
            Bundle bundle = new Bundle();
            bundle.putStringArray("tra", m);
            kalathi.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, kalathi, null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
}
