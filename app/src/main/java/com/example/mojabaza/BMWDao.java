package com.example.mojabaza;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface BMWDao {
    @Insert
    public void wstawDoBazy(BMW bmw);

    @Insert
    public void wstawListeDoBazy(BMW... bmw);

    @Delete
    public void usunZBazy(BMW bmw);

    @Update
    public void aktualizujFilmWBazie(BMW bmw);

    @Query("Select * from bmw")
    public List<BMW> zwrocWszystkieAutaZBazy();

    @Query("Select model from bmw where moc>:mocParametr")
    public List<String> zwrocModeleODanejMocy(int mocParametr);
}