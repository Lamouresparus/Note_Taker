package com.example.mvvmtesttask.local;

import androidx.lifecycle.LiveData;

import com.example.mvvmtesttask.model.entities.NoteData;
import com.example.mvvmtesttask.model.sources.LocalSource;
import com.example.mvvmtesttask.local.mapper.Mapper;

import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

public class LocalSourceImpl implements LocalSource {

    private final NoteDao noteDao;

    private final ExecutorService executors;

    @Inject
    public LocalSourceImpl(NoteDao noteDao, ExecutorService executors) {
        this.noteDao = noteDao;
        this.executors = executors;
    }

    @Override
    public void addNote(NoteData noteData) {

        executors.execute(() -> noteDao.saveNote(Mapper.noteDataToNoteEntity(noteData)));

    }

    @Override
    public void deleteNote(String noteId) {

        executors.execute(() -> noteDao.deleteNote(noteId));

    }

    @Override
    public void deleteAllNotes() {
        executors.execute(noteDao::deleteAllNotes);
    }

    @Override
    public void updateNote(NoteData noteData) {
        executors.execute(() -> noteDao.updateNote(Mapper.noteDataToNoteEntity(noteData)));

    }

    @Override
    public LiveData<List<NoteData>> getAllNotes() {
        return Mapper.noteEntityListToNoteDataList(noteDao.getAllNotes());

    }

    @Override
    public LiveData<NoteData> getNote(String noteId) {
        return Mapper.noteEntityToNoteData(noteDao.getNote(noteId));
    }
}
