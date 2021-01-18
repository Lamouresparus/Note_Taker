package com.example.mvvmtesttask.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NoteEntity.class}, version = 1, exportSchema = false)
public abstract class NoteDb extends RoomDatabase {
    public abstract NoteDao noteDao();
}
