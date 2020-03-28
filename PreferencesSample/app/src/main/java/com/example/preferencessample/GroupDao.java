package com.example.preferencessample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GroupDao {
    @Query("SELECT * FROM groups")
    List<Group> getGroups();

    @Query("SELECT * FROM groups WHERE id = :id")
    GroupWithContacts getGroupById(int id);

    @Insert
    void insert(Group group);

    @Update
    void update(Group group);

    @Delete
    void delete(Group group);
}
