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


public class MainActivity extends AppCompatActivity implements Agora_fragment.OnMessageSendListener {
     Toolbar toolbar;
     DrawerLayout drawerLayout;
     NavigationView navigationView;
     public static MyAppDatabase myAppDatabase;
     public static FragmentManager fragmentManager;
     public EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //δημιουργω την βάση μου
        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "UserBD").allowMainThreadQueries().build();


        //βαζω πρωτο fragment που θα εμφανιζεται το home_fragment
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_fragment()).commit();
        }

        //βρισκω και βαζω toolbar αυτο που εχω δημιουργήσει
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //βρίσκω το drawerlayout και το navigationview και δίνω εντολές σε ποιο
        // fragment θα πηγαινει κανεις πατωντας μια επιλογή από το μενού
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
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
        public void onMessageSend (String m){
            Kalathi kalathi = new Kalathi();
            Bundle bundle = new Bundle();
            bundle.putString("m", m);
            kalathi.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, kalathi, null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
}
