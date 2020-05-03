package com.example.eshop3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    // Για κάθε κλάση-πίνακα(Pelates-Proionta-Pwliseis) που έχω δημιουργήσει
    // δημιουργώ 3 μεθόδους(add,delete,update) που θα τις χρησιμοποιήσω
    // κάθε φορά που θα εισάγω, διαγράφω ή κάνω ενημέρωση ένα στοιχείο του πίνακα
    @Insert
    public void addPelati(Pelates pelates);

    @Delete
    public void deletePelati(Pelates pelates);

    @Update
    public void updatePelati(Pelates pelates);

    @Insert
    public void addProion(Proionta proionta);

    @Delete
    public void deleteProion(Proionta proionta);

    @Update
    public void updateProion(Proionta proionta);

    @Insert
    public void addPwliseis(Pwliseis pwliseis);

    @Delete
    public void deletePwliseis(Pwliseis pwliseis);

    @Update
    public void updatePwliseis(Pwliseis pwliseis);

    //Δημιουργώ κάποια Query τα οποία θα τα χρησιμοποιήσω
    //στη κλάση QueryFragment

    //Επιλέγω τα πάντα από τον πίνακα Pelates και επιστρέφει μια λίστα με αντικέιμετα τύπου Πελάτες
    @Query("select * from pelates ")
    public List<Pelates> getPelates();

    //Επιλέγω τα πάντα από τον πίνακα Proionta και επιστρέφει μια λίστα με αντικέιμετα τύπου Προϊόντα
    @Query("select * from proionta ")
    public List<Proionta> getProionta();

    //Επιλέγω τα πάντα από τον πίνακα Πωλήσεις και επιστρέφει μια λίστα με αντικέιμετα τύπου Πωλήσεις
    @Query("select * from pwliseis ")
    public List<Pwliseis> getPwliseis();

    // Επιλέγω το p_id και το τοποθετώ στον ακέραιο field1 και το proionta_posotita στον ακέραιο field2
    // που τους έχω ορίσει στη κλάση ResultInt καθώς δε μπορούν αλλιώς να πάρω έτσι τις τιμές τους από
    // Προϊόντα. Επιστρέγει μια λίστα με ακέραιους τύπου ResultInt, δηλαδή ([1,2],[3,4],[5,6])
    @Query("select  p_id as field1 , proionta_posotita as field2 " + " from proionta ")
    public List<ResultInt> getQuery1();

}
