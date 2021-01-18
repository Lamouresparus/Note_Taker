package com.example.mvvmtesttask.domain.repository;

import androidx.lifecycle.LiveData;

import com.example.mvvmtesttask.domain.entity.NoteDomain;

import java.util.List;

public interface NoteRepository {

    void addNote(NoteDomain noteDomain);

    void deleteNote(String noteId);

    void deleteAllNotes();

    void updateNote(NoteDomain noteDomain);

    LiveData<List<NoteDomain>> getAllNotes();

    LiveData<NoteDomain> getNote(String noteId);

}
