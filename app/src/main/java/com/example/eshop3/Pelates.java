package com.example.eshop3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "pelates" )
public class Pelates {
    @PrimaryKey  @ColumnInfo( name = "pid") @NonNull
    private int id;

    @ColumnInfo ( name = "pelates_name") @NonNull
    private String name;

    @ColumnInfo ( name = "pelates_surname") @NonNull
    private String surname;

    @ColumnInfo ( name = "pelates_poli") @NonNull
    private String poli;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }
}
