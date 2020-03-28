package com.example.preferencessample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {


    @Query("SELECT * FROM contacts")
    List<Contact> getContacts();

    @Query("SELECT * FROM contacts WHERE id = :id")
    Contact getContactById(int id);

    @Insert
    void insert(Contact contact);

    @Update
    void update(Contact contact);

    @Delete
    void delete(Contact contact);

}
