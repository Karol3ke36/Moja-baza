package com.example.mojabaza;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BMW.class}, version = 3)
public abstract class BMWDataBase extends RoomDatabase {
    public abstract BMWDao zwrocAutaDAO();
}
