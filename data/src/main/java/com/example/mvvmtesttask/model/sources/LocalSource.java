package com.example.mvvmtesttask.model.sources;

import androidx.lifecycle.LiveData;

import com.example.mvvmtesttask.model.entities.NoteData;

import java.util.List;

public interface LocalSource {

    void addNote(NoteData noteData);

    void deleteNote(String noteId);

    void deleteAllNotes();

    void updateNote(NoteData noteData);

    LiveData<List<NoteData>> getAllNotes();

    LiveData<NoteData> getNote(String noteId);

}
