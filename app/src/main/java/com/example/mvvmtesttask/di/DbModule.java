package com.example.mvvmtesttask.di;

import android.content.Context;

import androidx.room.Room;


import com.example.mvvmtesttask.local.NoteDao;
import com.example.mvvmtesttask.local.NoteDb;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ApplicationComponent.class)
public class DbModule {


    @Singleton
    @Provides
    public static NoteDb provideNoteDb(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, NoteDb.class, "note_database")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    public static NoteDao provideNoteDao(NoteDb noteDb) {
        return noteDb.noteDao();
    }


}
