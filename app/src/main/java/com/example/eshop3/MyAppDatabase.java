package com.example.eshop3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.eshop3.Pelates;

@Database(entities = {Pelates.class, Proionta.class, Pwliseis.class}, version = 1)

public abstract class MyAppDatabase extends RoomDatabase  {
    public abstract MyDao myDao();


}
