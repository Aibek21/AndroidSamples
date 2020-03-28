package com.example.preferencessample;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

public class MyApplication extends Application {

    public static MyApplication instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyApplication", "onCreate");
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "contact_db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

}
