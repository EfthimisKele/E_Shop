package com.example.eshop3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "pwliseis",
primaryKeys = {"pwlid","pwl_onoma","posoA","posoB","posoC","posoD"},
        foreignKeys = {
        @ForeignKey(entity = Pelates.class,
        parentColumns = "pid",
        childColumns = "pwlid",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)})

public class Pwliseis {
    @ColumnInfo (name = "pwlid") @NonNull
    private int ppid;

    @ColumnInfo (name = "pwl_onoma") @NonNull
    private String onoma;

    @ColumnInfo (name = "posoA")
    private int posoA;

    @ColumnInfo (name = "posoB")
    private int posoB;

    @ColumnInfo (name = "posoC")
    private int posoC;

    @ColumnInfo (name = "posoD")
    private int pososD;

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public String getOnoma() {
        return onoma;
    }

    public void setOnoma(String onoma) {
        this.onoma = onoma;
    }

    public int getPosoA() {
        return posoA;
    }

    public void setPosoA(int posoA) {
        this.posoA = posoA;
    }

    public int getPosoB() {
        return posoB;
    }

    public void setPosoB(int posoB) {
        this.posoB = posoB;
    }

    public int getPosoC() {
        return posoC;
    }

    public void setPosoC(int posoC) {
        this.posoC = posoC;
    }

    public int getPososD() {
        return pososD;
    }

    public void setPososD(int pososD) {
        this.pososD = pososD;
    }
}
