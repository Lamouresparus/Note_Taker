package com.example.mvvmtesttask.model.repositories;


import androidx.lifecycle.LiveData;

import com.example.mvvmtesttask.model.mapper.Mapper;
import com.example.mvvmtesttask.model.sources.LocalSource;
import com.example.mvvmtesttask.domain.entity.NoteDomain;
import com.example.mvvmtesttask.domain.repository.NoteRepository;

import java.util.List;

import javax.inject.Inject;

public class NoteRepositoryImpl implements NoteRepository {
    LocalSource localSource;

    @Inject
    public NoteRepositoryImpl(LocalSource localSource) {
        this.localSource = localSource;
    }

    @Override
    public void addNote(NoteDomain noteDomain) {
        localSource.addNote(Mapper.noteDomainToNoteData(noteDomain));
    }

    @Override
    public void deleteNote(String noteId) {
        localSource.deleteNote(noteId);

    }

    @Override
    public void deleteAllNotes() {
        localSource.deleteAllNotes();

    }

    @Override
    public void updateNote(NoteDomain noteDomain) {
        localSource.updateNote(Mapper.noteDomainToNoteData(noteDomain));
    }

    @Override
    public LiveData<List<NoteDomain>> getAllNotes() {
        return Mapper.noteDataListToNoteDomainList(localSource.getAllNotes());
    }

    @Override
    public LiveData<NoteDomain> getNote(String noteId) {
        return Mapper.noteEntityToNoteDomain(localSource.getNote(noteId));
    }

}
