package com.example.eshop3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.eshop3.Pelates;

/*
Δημιουργία της βάσης μου με τις κλάσεις Pelates, Proionta , Pwliseis , έκδοση δεν έχει τόσο θέμα
βάζει ο καθένας ότι θελει αριθμό., exportScehma το έβαλα false για να μην βγάζει ένα warning πλεον
H βάση μου κάνει extends την RoomDatabase που έχουμε εισάγει στο build grandle(Module :app)
Επισης περιέχει τo myDao
 */
@Database(entities = {Pelates.class, Proionta.class, Pwliseis.class}, version = 1, exportSchema = false)

public abstract class MyAppDatabase extends RoomDatabase  {
    public abstract MyDao myDao();
}
