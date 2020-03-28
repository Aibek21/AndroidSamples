package com.example.preferencessample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class, Group.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();

    public abstract GroupDao groupDao();
}
