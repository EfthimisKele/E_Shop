package com.example.eshop3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
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

    @Query("select * from pelates ")
    public List<Pelates> getPelates();

    @Query("select * from proionta ")
    public List<Proionta> getProionta();

    @Query("select * from pwliseis ")
    public List<Pwliseis> getPwliseis();

    @Query("select  p_id as field1 , proionta_posotita as field2 " + " from proionta ")
    public List<ResultInt> getQuery1();

}
