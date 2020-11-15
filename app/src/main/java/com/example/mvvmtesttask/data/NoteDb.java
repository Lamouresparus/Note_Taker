package com.example.mvvmtesttask.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {NoteEntity.class}, version = 1, exportSchema = false)
public abstract class NoteDb extends RoomDatabase {
    private static NoteDb noteDbInstance;
    public abstract NoteDao noteDao();


    public static NoteDb getDatabase(final Context context){
        if(noteDbInstance==null){
            synchronized (NoteDb.class){
                if(noteDbInstance==null){
                    noteDbInstance = Room.databaseBuilder(context.getApplicationContext(), NoteDb.class, "note_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return noteDbInstance;
    }

}
