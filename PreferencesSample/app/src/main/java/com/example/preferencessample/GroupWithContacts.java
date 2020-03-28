package com.example.preferencessample;

import androidx.room.Relation;

import java.util.List;

public class GroupWithContacts {
    public int id;

    public String name;

    @Relation(parentColumn = "id", entityColumn = "group_id")
    public List<Contact> contacts;
}
