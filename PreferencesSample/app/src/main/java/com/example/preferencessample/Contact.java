package com.example.preferencessample;


import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ColumnInfo.TEXT;

@Entity(tableName = "contacts",
        foreignKeys = @ForeignKey(entity = Group.class, parentColumns = "id", childColumns = "group_id"),
        indices = {@Index("phone")}
)
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "contact_name")
    public String name;
    @ColumnInfo(typeAffinity = TEXT)
    public String phone;
    @ColumnInfo(name = "group_id")
    public int groupId;
//    @Embedded
//    public Group group;
}
