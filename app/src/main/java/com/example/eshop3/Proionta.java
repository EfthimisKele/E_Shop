package com.example.eshop3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Δημιουργω τον πινακα Proionta με τις στήλες pid,posotita,proionta_xronologia,proionta_timi
//Κυριω κλειδι ειναι το pid το οποίο δε μπορεί να είναι null. Επισης δημιουργώ τα Setter και
//τα Getter για τη κάθε στήλη
@Entity(tableName = "proionta")
public class Proionta {
    @PrimaryKey @ColumnInfo ( name = "p_id") @NonNull
    private int pid;

    @ColumnInfo (name = "proionta_posotita")
    private int posotita;

    @ColumnInfo (name = "proionta_xronologia")
    private int xronologia;

    @ColumnInfo (name = "proionta_timi")
    private int timi;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPosotita() {
        return posotita;
    }

    public void setPosotita(int posotita) {
        this.posotita = posotita;
    }

    public int getXronologia() {
        return xronologia;
    }

    public void setXronologia(int xronologia) {
        this.xronologia = xronologia;
    }

    public int getTimi() {
        return timi;
    }

    public void setTimi(int timi) {
        this.timi = timi;
    }
}

