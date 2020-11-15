package com.example.mvvmtesttask.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {
    private static NoteRepository noteRepositoryInstance;
    private NoteDao noteDao;

    private ExecutorService executors;

    private NoteRepository(Application application) {
        NoteDb noteDb = NoteDb.getDatabase(application);
        noteDao = noteDb.noteDao();

        executors = Executors.newFixedThreadPool(3);
    }

    public void addNote(final NoteEntity note){

        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.saveNote(note);
            }
        });

    }

    public void deleteNote(final String noteId){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.deleteNote(noteId);
            }
        });
    }

    public void deleteAllNotes(){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.deleteAllNotes();
            }
        });
    }

    public void updateNote(final NoteEntity note){
        executors.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.updateNote(note);
            }
        });
    }
    public static NoteRepository getNoteRepositoryInstance(Application application) {
        if (noteRepositoryInstance == null) {
            synchronized (NoteRepository.class) {
                if (noteRepositoryInstance == null) {
                    noteRepositoryInstance = new NoteRepository(application);
                }
            }
        }
        return noteRepositoryInstance;
    }

    public LiveData<List<NoteEntity>> getAllNotes() {
        return noteDao.getAllNotes();
    }

    public LiveData<NoteEntity> getNote(String noteId) {
        return noteDao.getNote(noteId);
    }
}
