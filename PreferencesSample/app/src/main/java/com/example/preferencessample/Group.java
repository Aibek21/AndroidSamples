package com.example.preferencessample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "groups")
public class Group {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
}
