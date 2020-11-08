package com.example.roomsample

import android.app.Application
import android.util.Log
import androidx.room.Room


class MyApplication : Application() {
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        Log.e("MyApplication", "onCreate")
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "user_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object {
        lateinit var instance: MyApplication
    }

}