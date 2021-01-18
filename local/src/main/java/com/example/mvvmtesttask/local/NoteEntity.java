package com.example.mvvmtesttask.local;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class NoteEntity {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "note_title")
    private String title;

    @ColumnInfo(name = "note")
    private  String note;

    public NoteEntity(String id, String title, String note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }


}
